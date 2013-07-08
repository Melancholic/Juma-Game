/*
 * This clases contains the structure of
 * the ball,  users ball and a snake.
 */
package juma;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.util.*;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

class Snake {
    static CopyOnWriteArrayList<snakeBall> Snake;
    static private CopyOnWriteArrayList<Integer> Index;
    static double Time;
    static boolean isRun;
    static Texture StartPos = Graphics.loadTexture("dark");
    static Texture StopPos = Graphics.loadTexture("dark");

    static void init() {
        Time = 500;
        isRun = true;
        Snake = new CopyOnWriteArrayList<snakeBall>();
        Index = new CopyOnWriteArrayList<Integer>();
        Snake.add(new snakeBall(Level.getStartX(), Level.getStartY()));
        Index.add(0);
        for (int i = 1; i < (Level.lvl() + 10); ++i) {
            Snake.add(new snakeBall());
            Index.add(new Integer(0));
            Snake.get(i).X = Level.getStartX();
            Snake.get(i).Y = Level.getStartY();
        }

    }

    static void run() {
        //try{
        Index.set(0, new Integer((int) (Index.get(0).intValue() + (int) (Level.lvl() / 10) + 1)));
        if (Index.get(0).intValue() < Level.LevelsPoints.size()) {
            Snake.get(0).X = Level.LevelsPoints.get(Index.get(0).intValue()).X;
            Snake.get(0).Y = Level.LevelsPoints.get(Index.get(0).intValue()).Y;
            for (int i = 1; i < Snake.size(); ++i) {
                //  System.out.println("I: "+i+ "INDSize: "+ Index.size() );
                if (Math.abs(Index.get(i - 1) - Index.get(i)) >= ValIndBallSize() * 2) {
                    if (Index.size() != 1) {
                        Index.set(i, (int) (Index.get(i - 1).intValue() - ValIndBallSize() * 2));
                    }
                    if (Index.get(i).intValue() < Level.LevelsPoints.size()) {
                        // isRun=true;
                        Snake.get(i).X = Level.LevelsPoints.get(Index.get(i).intValue()).X;
                        Snake.get(i).Y = Level.LevelsPoints.get(Index.get(i).intValue()).Y;
                    } else {
                        isRun = false;
                        break;
                    }
                }
            }
        } else {
            isRun = false;
        }

        //}catch(IndexOutOfBoundsException e){
        //  e.printStackTrace();
        if (!isRun) {
            Snake.clear();
            Index.clear();
            System.out.println("End Game");

            Player.init();
        }

    }

    static void IsAdd() {
        for (int i = 0; i < Snake.size(); ++i) {
            if (Shoot.Ball != null && window.GetDistToPoint(Snake.get(i).X, Snake.get(i).Y,
                    Shoot.Ball.X, Shoot.Ball.Y) <= ball.Size) {
                AddToSnake(i, (ball) Shoot.Ball);
                Shoot.Ball = null;
                new streamsShootRunNext();
            }
        }
    }

    static void isRemove() {
        int Nums = 1;
        int j = 0;
        int Index = 0;
        boolean removed = false;
        for (int i = Snake.size() - 1 - 1; i >= 0; --i) {
            if (Snake.get(Snake.size() - 1).color.toString().equals(Snake.get(i).color.toString())) {
                Nums++;
                Index = i;
            } else {
                Nums = 1;
                break;
            }
        }
        if (Nums >= 3) {
            RemAtSnake(Index, Nums);
        }

        for (int i = 0; i <= Snake.size() - 1; ++i) {

            j = i;
            //     if(j<Snake.size()-1 && j>=0) {
            while (j < Snake.size() - 1 && Snake.get(j).color.toString().equals(Snake.get(j + 1).color.toString())) {
                j++;
            }
            //    }
            //else return;


            for (int k = i; k <= j; ++k) {
                if (Snake.get(k).getPlayers()) {
                    removed = true;
                    break;
                }
            }
            Nums = Math.abs(j - i) + 1;
            if (Nums >= 3 && removed) {
                removed = true;
            } else {
                removed = false;
            }
            if (removed) {
                RemAtSnake(i, Nums);
                i = 0;
            }
        }
        //

        // }

    }


    static private void RemAtSnake(int index, int nums) {
        int k = 0;
        if (nums == Snake.size()) {
            Snake.clear();
            Index.clear();
            Level.init(Level.lvl());
        } else {
            while (k < nums) {
                Snake.remove(index);
                Index.remove(index);
                k++;
            }
            for (int i = index - 2; i >= 0; i--) {
                try {

                    Index.set(i, Index.get(i + 1).intValue() + ValIndBallSize() * 2);
                    Snake.get(i).X = Level.LevelsPoints.get(Index.get(i).intValue()).X;
                    Snake.get(i).Y = Level.LevelsPoints.get(Index.get(i).intValue()).Y;
                } catch (ArrayIndexOutOfBoundsException ex1) {
                    System.out.println("SizeInd: " + Index.size() + "i: " + i);
                    System.out.println("SizeSnk: " + Snake.size() + "i: " + i);

                }
            }

        }

    }

    static private void AddToSnake(int index, ball Ball) {
        snakeBall BTmp = new snakeBall(Ball);
        try {
            BTmp.color = (BALLS) Shoot.Ball.color.clone();
        } catch (CloneNotSupportedException ex) {
            System.err.println("Err Copy in Snake::AddToSnake");
        }
        try {
            Snake.add(index, BTmp);
            Snake.get(index).setPlayers();
            if (index != 0) {
                Index.add(index, Index.get(index - 1).intValue());
                for (int i = index - 1; i > 0; --i) {
                    Index.set(i, Index.get(i - 1));
                    Snake.get(i).X = Level.LevelsPoints.get(Index.get(i).intValue()).X;
                    Snake.get(i).Y = Level.LevelsPoints.get(Index.get(i).intValue()).Y;
                }
            } else {
                Index.add(index, Index.get(index + 1).intValue() + ValIndBallSize() * 2);
            }
            Index.set(0, Index.get(0).intValue() + ValIndBallSize() * 2);
            Snake.get(0).X = Level.LevelsPoints.get(Index.get(0).intValue()).X;
            Snake.get(0).Y = Level.LevelsPoints.get(Index.get(0).intValue()).Y;
        } catch (IndexOutOfBoundsException ex) {
            System.out.print(index);
        }

    }

    static void print() {
        try {
            for (int i = Snake.size() - 1; i >= 0; --i) {
                window.printBallObj(Snake.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Err in Snake::MenuPricess::InterruptedException");
        }
    }

    static private int ValIndBallSize() {
        int tmp = 0;
        point x = Level.LevelsPoints.get(tmp);
        while (Math.abs(window.GetDistToPoint(x.X, x.Y, Level.LevelsPoints.get(tmp).X,
                Level.LevelsPoints.get(tmp).Y) - ball.Size) > 1) {
            tmp++;
        }
        return tmp;
    }
}

