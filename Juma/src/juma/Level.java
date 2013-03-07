/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author sosnov
 */
public class Level {
    static private int PlayerX;
    static private int PlayerY;
    static private int lvl;
    static private double StartX;
    static private double StartY;
    static ArrayList<point> LevelsPoints=new ArrayList<>();
    static long MaxScore=500;
    static void init(int Level){
        PlayerX=window.Width/2;
        PlayerY=window.Height/2;
        StartX=50;
        StartY=50;
        lvl=Level;
        MaxScore=lvl*MaxScore;
        Snake.init();
       
    }
    static int getPlayerX(){
        return PlayerX;
    }
    static int getPlayerY(){
        return PlayerY;
    }
        static double getStartX(){
        return StartX;
    }
    static double getStartY(){
        return StartY;
    }
    static int lvl(){
        return lvl;
    }
    static void loadBin2List(long LvlValue){
         try {
            DataInputStream file = new DataInputStream(new FileInputStream("./data/levels/"+Long.toString(LvlValue)+".dat"));
            double tmpX,tmpY;
            while(true){
                try{
                tmpX=file.readDouble();
                tmpY=file.readDouble();
                LevelsPoints.add(new point(tmpX,tmpY));
                }catch(NullPointerException e){
                    break;
                }
            }
                file.close();
            } catch (IOException ex) {
            System.err.println("Err in level::loadBin2List::IOException");
            }
    }

}

class point{
        double X;
        double Y;
        point(double x, double y){
            X=x;
            Y=y;
        }

    @Override
     public String toString(){
            String s= X+" "+Y;
            return s;
        }
                
}


