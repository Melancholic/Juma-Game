/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;
import static org.lwjgl.opengl.GL11.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

class Graphics implements Cloneable{
    static final Texture TexRed = loadTexture("red");
    static final Texture TexBlue = loadTexture("blue");
    static final Texture TexGreen = loadTexture("green");
    static final Texture TexYellow = loadTexture("yellow");
    static final Texture TexBrown = loadTexture("brown");
    static final Texture TexBlack = loadTexture("black");
   
    static Texture getTexColor(BALLS ball){
        Texture tmpTex;
        switch(ball.toString()){
            case "red": 
                tmpTex= TexRed;
                break; 
            case "blue": 
                tmpTex= TexBlue;
                break;     
            case "green": 
                tmpTex= TexGreen;
                break;
            case "yellow": 
                tmpTex= TexYellow;
                break;
            case "brown": 
                tmpTex= TexBrown;
                break;
            case "black": 
                tmpTex= TexBlack;
                break;
            default: 
                throw new IllegalArgumentException("Invalid value of color" );
        }
        return tmpTex;
    }
    
    static Texture loadTexture(String key){
            try {
                return TextureLoader.getTexture("PNG",new FileInputStream(new File("res/"+key+".png")));
            } catch (FileNotFoundException e) {
                System.out.print("err1");
                e.printStackTrace();
        } catch (IOException e) {
            System.out.print("err1");
            e.printStackTrace();
        }
        return null;
        }
        @Override
    public Graphics clone() throws CloneNotSupportedException {
        return (Graphics) super.clone();
    }

}