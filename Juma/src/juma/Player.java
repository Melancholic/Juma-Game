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
    static final int X=window.Width/2;
    static final int Y=window.Height/2;
    static final int Size = 250;
    static void init(){
        for (int i=0;i!=TexPlayer.length;++i){
            TexPlayer[i]= Graphics.loadTexture("rog"+(i+1));
        }
    }
    
}
