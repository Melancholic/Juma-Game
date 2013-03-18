/*
 * This clases contains the structure of
 * the ball,  users ball and a snake.
 */
package juma;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import java.util.*;
import java.util.logging.Logger;
/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */


class BALLS implements Cloneable{

    private String Color;
    Texture TexColor;
    static final String[] Colors ={"red","green", "blue","yellow","brown","black"};
    
    BALLS(){
        int i=-1;
        while(i>Colors.length-1  || i<0){
            i=(int)(Math.random()*10);
        }
        this.Color=Colors[i];
        this.TexColor=Graphics.getTexColor(this.Color);
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
    static final int BallsNums=6;

    ball(double x, double y){
        this.X=x;
        this.Y=y;
        color=new BALLS();
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
    @Override
    public BALLS clone() throws CloneNotSupportedException {
        return (BALLS) super.clone();
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

class snakeBall extends ball{
    private double vX;
    private double vY;
    snakeBall(double x, double y){
        super(x,y);
    }
    snakeBall(ball obj){
       X=obj.X;
       Y=obj.Y;
        try {
            color = (BALLS)obj.color.clone();
        } catch (CloneNotSupportedException ex) {
            ;
        }
       
    }
    
     snakeBall(){
         X=Level.getStartX();
         Y=Level.getStartY();
         this.color= new BALLS();
     }
}

class Snake {
    static ArrayList<snakeBall> Snake ;
    static private ArrayList<Integer> Index; 
    static double Time;
    static void init(){
        Time=500;
        Snake= new ArrayList<>();
        Index=new ArrayList<>();
        Snake.add(new snakeBall(Level.getStartX(),Level.getStartY()));
        Index.add(0);
        for(int i=1;i<(Level.lvl()+10)*2;++i){
            Snake.add(new snakeBall());
            Index.add(new Integer(0));
            Snake.get(i).X=Level.getStartX();
            Snake.get(i).Y=Level.getStartY();
        }
        
        System.err.println(Snake.size());
        System.err.println(Index.size());
      
    }

    static void run(){
        try{
            System.out.println(Level.LevelsPoints.get(0).X+" "+Level.LevelsPoints.get(0).Y);
            Snake.get(0).X=Level.LevelsPoints.get(Index.get(0).intValue()).X;
            Snake.get(0).Y=Level.LevelsPoints.get(Index.get(0).intValue()).Y;
            Index.set(0,new Integer((int)(Index.get(0).intValue()+(int)(Level.lvl()/10)+1)));  
            System.out.println(Index.get(0).intValue()+"  "+Level.LevelsPoints.size());
            for(int i=1;i<Snake.size();++i){
                if(Math.abs(Index.get(i-1)-Index.get(i))>= ValIndBallSize()*2){
                   Index.set(i,(int)(Index.get(i-1).intValue()-ValIndBallSize()*2)); 
                   Snake.get(i).X= Level.LevelsPoints.get(Index.get(i).intValue()).X;
                    Snake.get(i).Y= Level.LevelsPoints.get(Index.get(i).intValue()).Y;                                  
                }
            }

        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            Snake.clear();
            Index.clear();
            System.out.println("End Game");
            Level.init(Level.lvl());
       }
        
}
    static void IsAdd(){
        for(int i=0;i<Snake.size();++i){
             if(Shoot.Ball!=null && window.GetDistToPoint(Snake.get(i).X,Snake.get(i).Y,
                Shoot.Ball.X,Shoot.Ball.Y)<=ball.Size){
                    AddToSnake(i,(ball)Shoot.Ball);
                    Shoot.Ball=null;
                    new streamsShootRunNext(); 
                }
        }
    }
        
    static private void AddToSnake(int index, ball Ball){
                snakeBall BTmp= new snakeBall(Ball);
                try {
                    BTmp.color=(BALLS)Shoot.Ball.color.clone();
                } catch (CloneNotSupportedException ex) {
                    System.err.println("Err Copy in Snake::AddToSnake");
                }
                try{
                    Snake.add(index,BTmp);  
                    if(index!=0){
                        Index.add(index, Index.get(index-1).intValue());
                        for(int i =index-1;i>0;--i){
                            Index.set(i,Index.get(i-1));
                            Snake.get(i).X= Level.LevelsPoints.get(Index.get(i).intValue()).X;
                            Snake.get(i).Y= Level.LevelsPoints.get(Index.get(i).intValue()).Y;                    
                        }
                    }else{
                        Index.add(index, Index.get(index+1).intValue()+ ValIndBallSize()*2);
                    }
                    Index.set(0,Index.get(0).intValue()+ ValIndBallSize()*2);
                    Snake.get(0).X= Level.LevelsPoints.get(Index.get(0).intValue()).X;
                    Snake.get(0).Y= Level.LevelsPoints.get(Index.get(0).intValue()).Y;
                }catch(IndexOutOfBoundsException ex){
                    System.out.print(index);
                }
            
 }
    static void print(){
        for(int i=0;i<Snake.size();++i){
            window.printBallObj(Snake.get(i));
        }
    }

    static private int ValIndBallSize(){
        int tmp=0;
        point x=Level.LevelsPoints.get(tmp);
        while(Math.abs(window.GetDistToPoint(x.X,x.Y,Level.LevelsPoints.get(tmp).X,
          Level.LevelsPoints.get(tmp).Y)-ball.Size)>1){
            tmp++;
        }
        return tmp;
    }
}
