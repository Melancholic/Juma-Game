/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

/**
 * @author Nagorny Andrey
 * @email grizzly-terror@yandex.ru
 */

public class Key {
    static void IsBind() {
        while (Mouse.next()) {
            if (PauseWindow.atButtonPos(Mouse.getX(), Mouse.getY()) && !window.Pause && Mouse.isButtonDown(0)) {
                window.runMenu();
            }
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE || Keyboard.getEventKey() == Keyboard.KEY_P) {
                    window.runMenu();
                }
            }
        }
        if (Mouse.isButtonDown(0) && Shoot.ballToStartPos() && !PauseWindow.atButtonPos(Mouse.getX(), Mouse.getY())) {
            System.out.println(Mouse.getX() + " " + Mouse.getY());
            Shoot.make(Mouse.getX(), Mouse.getY());
        }
    }

}
