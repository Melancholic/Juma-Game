/*
 * This clases contains the structure of
 * the ball,  users ball adn a snake.
 */
package juma;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
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
    BALLS color;
    Texture TexColor;
    static final int BallsNums=6;

    ball(double x, double y){
        this.X=x;
        this.Y=y;
    }
    ball(){
        this.X=0;
        this.Y=0;
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

public class Snake {
    
    
}
