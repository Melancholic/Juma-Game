/*
 * This class is responsible for the events of the shot
 */
package juma;

import java.util.*;

/**
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

class Shoot {
    static final int X = Level.getPlayerX();
    static final int Y = Level.getPlayerY();
    static userBall Ball = new userBall(X, Y);
    static private BALLS next;

    static void CreateBall(double vX, double vY) {
        Ball = new userBall(X, Y);
        if (next == null) {
            next = new BALLS(Snake.Snake);
            Ball.color = new BALLS(Snake.Snake);
        } else {
            try {
                Ball.color = (BALLS) next.clone();
                next = new BALLS(Snake.Snake);
            } catch (CloneNotSupportedException e) {
                System.out.println("err::Shoot::CreateBall()");
            }
        }
    }

    static BALLS getNext() {
        return next;
    }

    static void make(int mouseX, int mouseY) {
        double vX = (mouseX - X) / Math.sqrt((double) (Math.pow(mouseX - X, 2) +
                (Math.pow(mouseY - Y, 2)))) * (window.Height + window.Width) * 0.005;
        double vY = (Y - mouseY) / Math.sqrt((double) (Math.pow(mouseX - X, 2) +
                (Math.pow(mouseY - Y, 2)))) * (window.Height + window.Width) * 0.005;
        Ball.setSpeeds(vX, vY);
    }

    static void runNext() throws CloneNotSupportedException {
        if (Shoot.Ball == null || window.incorredValsDisplay((int) Ball.getX(), (int) Ball.getY())) {
            CreateBall(X, Y);
        }
    }

    static boolean ballToStartPos() {
        return (Shoot.Ball != null && Shoot.Ball.getX() == Shoot.X) && (Shoot.Ball.getY() == Shoot.Y);
    }
}
