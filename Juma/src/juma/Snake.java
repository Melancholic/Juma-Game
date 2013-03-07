/*
 * This clases contains the structure of
 * the ball,  users ball adn a snake.
 */
package juma;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import java.util.*;
/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */


class BALLS implements Cloneable{

    private String Color;
    static final String[] Colors ={"red","green", "blue","yellow","brown","black"};
    
    BALLS(){
        int i=-1;
        while(i>Colors.length-1  || i<0){
            i=(int)(Math.random()*10);
        }
        this.Color=Colors[i];
    }
    
    @Override
    public String toString(){
        return this.Color;
    }
    
    @Override
    public BALLS clone() throws CloneNotSupportedException {
        return (BALLS) super.clone();
    }

}

class ball implements Cloneable{
    protected double X;
    protected double Y;
    static protected final double Size=((window.Height+window.Width)*0.01);
    BALLS color;
    Texture TexColor;
    static final int BallsNums=6;

    ball(double x, double y){
        this.X=x;
        this.Y=y;
        color=new BALLS();
        TexColor=Graphics.getTexColor(color);
    }
    ball(){
        this.X=0;
        this.Y=0;
        this.color= new BALLS();
    }
    
     double getX(){
        return X;
    }
    double getY(){
         return Y;
    }
    
    
    void setCoordinates(double x, double y){
         this.X=x;
        this.Y=y;  
    }
}

class userBall extends ball{
    private double vX;
    private double vY;
    userBall(double x, double y){
        super(x,y);
    }
    void run(){
        this.X+=vX;
         this.Y+=vY;
    }
    void setSpeeds(double vx, double vy){
        this.vX=vx;
        this.vY=vy;
    }
}

class Snake {
    static ArrayList<ball> Snake = new ArrayList<>();
    static private int[] Index; 
    static void init(){
        Snake.add(new ball(Level.getStartX(),Level.getStartY()));
        Snake.get(0).TexColor=Graphics.getTexColor(Snake.get(0).color);
        for(int i=1;i<(Level.lvl()+10)*2;++i){
            Snake.add(new ball());
             Snake.get(i).TexColor=Graphics.getTexColor(Snake.get(i).color);
        }
        Index=new int[Snake.size()];
        for (int i=0;i<Snake.size();++i){
            Index[i]=0;
        }
    }

    static void run(){
        try{
            
            Snake.get(0).X=Level.LevelsPoints.get(Index[0]).X;
            Snake.get(0).Y=Level.LevelsPoints.get(Index[0]).Y;
            Index[0]++;
            for(int i=1;i<Snake.size();++i){ 
                if(window.GetDistToPoint(Snake.get(i-1).X, Snake.get(i-1).Y, Snake.get(i).X,Snake.get(i).Y)>=ball.Size*2){                  
                    Snake.get(i).X= Level.LevelsPoints.get(Index[i]).X;
                    Snake.get(i).Y= Level.LevelsPoints.get(Index[i]).Y;
                    Index[i]++;
                }
            }
        }catch(IndexOutOfBoundsException e){
            Snake.clear();
            System.out.println("End Game");
            Level.init(Level.lvl());
       }
        
}
    static void print(){
        for(int i=0;i<Snake.size();++i){
            window.printBallObj(Snake.get(i));
           // System.err.println(Snake.get(i).color.toString());
        }
    }
       
}
