/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;
import org.newdawn.slick.opengl.Texture;
/**
 *
 * @author sosnov
 */
public class Player {
    static Texture[] TexPlayer=new Texture[3];
    static private int X;
    static private int Y;
    static final double Size =  ((window.Height+window.Width)*0.13);
    static void init(){
        X=Level.getPlayerX();
        Y=Level.getPlayerY();
        for (int i=0;i!=TexPlayer.length;++i){
            TexPlayer[i]= Graphics.loadTexture("rog"+(i+1));
        }
    }
    static int getX(){
        return X;
    }
    static int getY(){
        return Y;
    }
    
}
