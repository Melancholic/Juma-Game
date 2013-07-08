/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.newdawn.slick.opengl.Texture;

/**
 * @author sosnov
 */
public class Level {
    static private int PlayerX;
    static private int PlayerY;
    static private int lvl;
    static private double StartX;
    static private double StartY;
    static private double StopX;
    static private double StopY;
    static ArrayList<point> LevelsPoints;
    static long MaxScore = 500;
    static Texture pathTexture =Graphics.loadTexture("path");
    static double pathSize=0.1;

    static void init(int Level) {
        LevelsPoints = new ArrayList<point>();

        PlayerX = window.Width / 2;
        PlayerY = window.Height / 2;
        StartX = window.Width / 20;
        StartY = window.Height / 15;
        StopX = window.Width * 0.95;
        StopY = window.Height * 0.95;
        lvl = Level;
        loadBin2List((int) (Level % 9));
        MaxScore = lvl * MaxScore;
        Snake.init();

    }


    static int getPlayerX() {
        return PlayerX;
    }

    static int getPlayerY() {
        return PlayerY;
    }

    static double getStartX() {
        return StartX;
    }

    static double getStartY() {
        return StartY;
    }

    static double getStopX() {
        return StopX;
    }

    static double getStopY() {
        return StopY;
    }

    static int lvl() {
        return lvl;
    }

    static void loadBin2List(long LvlValue) {
        try {
            DataInputStream file = new DataInputStream(new FileInputStream("./data/levels/" + Long.toString(LvlValue) + ".dat"));
        } catch (IOException ex) {
            Createlevel.CreateDefault((int) LvlValue);
        }
        try {

            DataInputStream file = new DataInputStream(new FileInputStream("./data/levels/" + Long.toString(LvlValue) + ".dat"));
            double tmpX, tmpY;
            while (true) {
                try {
                    tmpX = file.readDouble();
                    tmpY = file.readDouble();
                    LevelsPoints.add(new point(tmpX, tmpY));
                } catch (IOException e) {
                    break;
                }
            }
            file.close();
        } catch (IOException ex) {
            System.err.println("Err in level::loadBin2List::IOException");
            ex.printStackTrace();
        }
    }

}

class point {
    double X;
    double Y;

    point(double x, double y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        String s = X + " " + Y;
        return s;
    }

}


