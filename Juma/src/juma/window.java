package juma;

/*
 *This class is responsible for drowing the window
 *and the game loop. 
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
 import org.lwjgl.opengl.Display; 
import org.lwjgl.opengl.DisplayMode;
 import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */
public class window {
    static  final int Height=780;
    static final int Width=1024;
     Texture Baground;
    static boolean incorredValsDisplay(int width, int height){
        return (height>Height || height<0) ||(width>Width || width<0);
    }
    
       static void printBallObj(ball Ball){
        final byte ObjSize=25;
           if(Ball.TexColor!=null){
            Ball.TexColor.bind();}
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4ub((byte) 255, (byte) 255, (byte)255, (byte)255); 
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor4f(1.0f,1.0f,1.0f,0.0f); 
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2i((int)Ball.getX()-ObjSize,(int)Ball.getY()-ObjSize);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2i((int)Ball.getX()-ObjSize,(int)Ball.getY()+ObjSize);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2i((int)Ball.getX()+ObjSize,(int)Ball.getY()+ObjSize);
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2i((int)Ball.getX()+ObjSize,(int)Ball.getY()-ObjSize);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
    }
    
    public void start(){
        try{
            Display.setDisplayMode(new DisplayMode(Width,Height));
            Display.create();
            Display.setInitialBackground(0, 0, 0);
            
              Display.setTitle("Juma");
        }catch (LWJGLException e){
            e.printStackTrace();
            System.exit(0);
        }
        Baground= Graphics.loadTexture("baground2");
        Player.init();
        Shoot.CreateBall(0, 0);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Width, Height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);   
        //GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_ALPHA);
        GL11.glTexEnvi( GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE );
        drawBaground();
        printPlayer();
        while(!Display.isCloseRequested()){
             GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);   
            drawBaground();
             printPlayer();
           /*  Key.IsBind();
             Shoot.Ball.run();
             Shoot.runNext();*/
             //Streams.mainStreams();
            new streamsKeyIsBind();
            new streamsShootBallRun();
            new streamsShootRunNext();
            printBallObj(Shoot.Ball);
           /* try {
                Thread.sleep(2); // Спать 5 минут
            } catch (InterruptedException ex) { }*/
            Display.update();
            Display.sync(2000);
        }
        Display.destroy();
    }
    void drawBaground(){
 GL11.glDisable(GL11.GL_DEPTH_TEST);  
  GL11.glDepthMask(false);

  GL11.glLoadIdentity();
  GL11.glMatrixMode(GL11.GL_PROJECTION);
  GL11.glPushMatrix();
  GL11.glLoadIdentity();
  GL11.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);
 GL11.glTexEnvf (GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE); 

  GL11.glMatrixMode(GL11.GL_MODELVIEW);
 // GL11.glPushMatrix();
Baground.bind();
GL11.glBegin(GL11.GL_QUADS);
  GL11.glTexCoord2f(0.0f, 0.0f);//1
  GL11.glVertex2f(0.0f, 0.0f);

  GL11.glTexCoord2f(0.0f, 1.0f);//2
  GL11.glVertex2f(0.0f, 1.0f);

  GL11.glTexCoord2f(1.0f, 1.0f);//3
  GL11.glVertex2f(1.0f, 1.0f);

  GL11.glTexCoord2f(1.0f, 0.0f);//4
  GL11.glVertex2f(1.0f, 0.0f);

GL11.glEnd();

  GL11.glMatrixMode(GL11.GL_PROJECTION);
  GL11.glPopMatrix();
  GL11.glMatrixMode( GL11.GL_MODELVIEW);
  GL11.glPopMatrix();
  GL11.glTexEnvf (GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_REPLACE); 

  GL11.glDepthMask(true);
//  GL11.glEnable(GL11.GL_DEPTH_TEST);  
        
        
    }
    
      static void printPlayer(){
         float Trot;
        Trot = 90-(float)(Math.atan2(Mouse.getY()-Player.Y,Mouse.getX()-Player.X))*180/(float)Math.PI;
           System.out.println(Trot);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4ub((byte) 255, (byte) 255, (byte)255, (byte)255); 
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
  GL11.glLoadIdentity();
  GL11.glDisable(GL11.GL_DEPTH_TEST);
  GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT );
  GL11.glPushMatrix();
  GL11.glTranslatef(Player.X, Player.Y, 0);
  GL11.glRotatef(Trot, 0, 0, 1);
  double Dist=GetDistToPoint(Shoot.Ball.X,Shoot.Ball.Y,Player.X,Player.Y);
        if(Shoot.ballToStartPos()){
            Player.TexPlayer[0].bind();
        } else if(Dist<70){
            Player.TexPlayer[1].bind();
        } else  Player.TexPlayer[2].bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor4f(1.0f,1.0f,1.0f,0.0f);        
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2i(-(int)Player.Size/2,-(int)Player.Size/2);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2i(+(int)Player.Size/2,-(int)Player.Size/2);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2i(+(int)Player.Size/2,+(int)Player.Size/2);
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2i(-(int)Player.Size/2,+(int)Player.Size/2);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        
GL11.glPopMatrix();
    }
      static double GetDistToPoint(double X1, double Y1, double X2, double Y2){
          return Math.sqrt(Math.pow(X1-X2, 2)+(Math.pow(Y1-Y2, 2)));
      }
}

