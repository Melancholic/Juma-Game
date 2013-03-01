/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

public class Key {
    static void IsBind(){
         if (Mouse.isButtonDown(0) && Shoot.ballToStartPos()){
             Shoot.make(Mouse.getX(), Mouse.getY());
         }
    }
}
