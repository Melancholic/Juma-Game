/*
 * This class is responsible for the events of the shot
 */
package juma;

/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

class Shoot {
    static final int Y=window.Height/2;
    static final int X=window.Width/2;
    static userBall Ball = new userBall(X,Y);
    static private BALLS next;
   
    static void CreateBall(double vX, double vY){
        Ball = new userBall(X,Y);
        if(next==null){
            next = new BALLS();
            Ball.color= new BALLS();
        }else{
             try {
            Ball.color=(BALLS) next.clone();
            next=new BALLS();
             } catch (CloneNotSupportedException e) {
                    System.out.println("err::Shoot::CreateBall()");
             }
        }
        Ball.TexColor=null;
        Ball.TexColor=Graphics.getTexColor(Ball.color);
        System.out.println(Ball.color.toString());
    }
    
    static BALLS getNext(){
        return next;
    }
    static void make(int mouseX, int mouseY){
        double vX=(mouseX-X)/Math.sqrt((double)(Math.pow(mouseX-X, 2)+(Math.pow(mouseY-Y, 2))));
        double vY=(Y-mouseY)/Math.sqrt((double)(Math.pow(mouseX-X, 2)+(Math.pow(mouseY-Y, 2))));
        Ball.setSpeeds(vX, vY);
    }

    static void runNext() throws CloneNotSupportedException{
        if(window.incorredValsDisplay((int)Ball.getX(), (int)Ball.getY())){
            CreateBall(X,Y);
        }
    }
    static boolean ballToStartPos(){
        return (Shoot.Ball.getX()==Shoot.X) && (Shoot.Ball.getY()==Shoot.Y);
    }
    
}
