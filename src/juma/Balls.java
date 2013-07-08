/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;

import java.util.*;

import org.newdawn.slick.opengl.Texture;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sosnov
 */


class BALLS implements Cloneable {

    private String Color;
    Texture TexColor;
    static final String[] Colors = {"red", "green", "blue", "yellow", "brown", "black"};

    BALLS() {
        int i = -1;
        while (i > Colors.length - 1 || i < 0) {
            i = (int) (Math.random() * 10);
        }
        this.Color = Colors[i];
        this.TexColor = Graphics.getTexColor(this.Color);
    }

    BALLS(CopyOnWriteArrayList<snakeBall> balls) {
        if (balls.size() != 0) {


            int i = -1;
            while (i > balls.size() || i < 0) {
                i = (int) (Math.random() * balls.size());
            }
            this.Color = balls.get(i).color.toString();
            this.TexColor = Graphics.getTexColor(this.Color);
        }

    }

    @Override
    public String toString() {
        return this.Color;
    }

    @Override
    public BALLS clone() throws CloneNotSupportedException {
        return (BALLS) super.clone();
    }

}

class ball implements Cloneable {
    protected double X;
    protected double Y;
    static protected final double Size = ((window.Height + window.Width) * 0.01);
    BALLS color;
    static final int BallsNums = 6;

    ball(double x, double y) {
        this.X = x;
        this.Y = y;
        color = new BALLS();
    }

    ball() {
        this.X = 0;
        this.Y = 0;
        this.color = new BALLS();
    }

    double getX() {
        return X;
    }

    double getY() {
        return Y;
    }


    void setCoordinates(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public BALLS clone() throws CloneNotSupportedException {
        return (BALLS) super.clone();
    }
}

class userBall extends ball {
    private double vX;
    private double vY;

    userBall(double x, double y) {
        super(x, y);
    }

    void run() {
        this.X += vX;
        this.Y += vY;
    }

    void setSpeeds(double vx, double vy) {
        this.vX = vx;
        this.vY = vy;
    }
}

class snakeBall extends ball {
    private boolean Players;

    snakeBall(double x, double y) {
        super(x, y);
    }

    snakeBall(ball obj) {
        X = obj.X;
        Y = obj.Y;
        Players = true;
        try {
            color = (BALLS) obj.color.clone();
        } catch (CloneNotSupportedException ex) {
            ;
        }
    }

    boolean getPlayers() {
        return Players;
    }

    void setPlayers() {
        Players = true;
    }

    void setNonePlayers() {
        Players = false;
    }


    snakeBall() {
        X = Level.getStartX();
        Y = Level.getStartY();
        this.color = new BALLS();
        Players = false;
    }
}

