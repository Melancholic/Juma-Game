/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;


import java.util.logging.Logger;

/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

class Streams {  
    static void mainStreams(){
       new streamsKeyIsBind();
        new streamsShootBallRun();
        new streamsShootRunNext();
      //  streamsPrintBallObj streamsPrintBallObj = new streamsPrintBallObj();
        
    }
    
    
}

class streamsKeyIsBind implements Runnable{
        Thread tmp;
        streamsKeyIsBind(){
            tmp=new Thread(this,"streamsKeyIsBind");
            tmp.start();
        }
        @Override
        public void run(){
            Key.IsBind();
        }
    }

class streamsShootBallRun implements Runnable{
        Thread tmp;
        streamsShootBallRun(){
            tmp=new Thread(this,"streamsShootBallRun");
            tmp.start();
        }
        @Override
        public void run(){
             Shoot.Ball.run();
        }        
}

class streamsShootRunNext implements Runnable{
        Thread tmp;
        streamsShootRunNext(){
            tmp=new Thread(this,"streamsShootRunNext");
            tmp.start();
        }
        @Override
        public void run(){
            try{
            Shoot.runNext();
            } catch (CloneNotSupportedException e) {
                    System.out.println("Error int the streamsShootRunNext::run()");
             }
        }
    }
 
class streamsUpdateFPS implements Runnable{
        Thread tmp;
        streamsUpdateFPS(){
            tmp=new Thread(this,"UpdateFPS");
            tmp.start();
        }
        @Override
        public void run(){
             window.updateFPS();
        }
}
class streamsIsLvlUp implements Runnable{
        Thread tmp;
        streamsIsLvlUp(){
            tmp=new Thread(this,"Streams Is Lvl up");
            tmp.start();
        }
        @Override
        public void run(){
             if (Player.getScore()>=Level.MaxScore){
                 Player.levelUp();
             }
        }
}

class streamsSnakeRun implements Runnable{
        Thread tmp;
        streamsSnakeRun(){
            tmp=new Thread(this,"SnakeRun");
            tmp.start();
        }
        @Override
        public void run(){
            Snake.run();
        }
}

class streamsSnakeIsAdd implements Runnable{
        Thread tmp;
        streamsSnakeIsAdd(){
            tmp=new Thread(this,"SnakeRun");
            tmp.start();
        }
        @Override
        public void run(){
            Snake.IsAdd();
        }
}
 
