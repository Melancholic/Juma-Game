/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.lwjgl.input.Mouse;


/**
 * @author sosnov
 */
class PauseWindow {
    static double buttonX;
    static double buttonY;
    static int buttonWidth;
    static int buttonHeight;
    static private Texture TexMenuButton;
    static Texture MenuBaground;

    static void Draw() {
        try {
            juma.PauseWindow.MenuBaground.bind();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) 255);
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.0f);

            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2i(0, 0);
            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2i(0, window.Height);
            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2i(window.Width, window.Height);
            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2i(window.Width, 0);
            GL11.glEnd();
            GL11.glDisable(GL11.GL_BLEND);
            DrawMenuButton();
        } catch (NullPointerException e) {
            return;
        }
    }

    static void init() {
        buttonWidth = window.Width / 15;
        buttonHeight = window.Height / 30;
        buttonX = window.Width * 0.95;
        buttonY = window.Height * 0.05;
        TexMenuButton = Graphics.loadTexture("bmenu");//MenuBaground
        MenuBaground = Graphics.loadTexture("MenuBaground");

    }

    static void DrawMenuButton() {
        try {
            juma.PauseWindow.TexMenuButton.bind();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) 255);
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.0f);

            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2i((int) (buttonX - buttonWidth), (int) (buttonY - buttonHeight));
            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2i((int) (buttonX - buttonWidth), (int) (buttonY + buttonHeight));
            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2i((int) (buttonX + buttonWidth), (int) (buttonY + buttonHeight));
            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2i((int) (buttonX + buttonWidth), (int) (buttonY - buttonHeight));
            GL11.glEnd();
            GL11.glDisable(GL11.GL_BLEND);
        } catch (NullPointerException e) {
            return;
        }
    }

    static boolean MenuExit() {
        Display.update();
        if (Display.isCloseRequested()) {
            Display.destroy();

        }
        while (Mouse.next()) {
            if (PauseWindow.atButtonPos(Mouse.getX(), Mouse.getY()) && window.Pause && Mouse.isButtonDown(0)) {
                return true;
            }
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE || Keyboard.getEventKey() == Keyboard.KEY_P) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean atButtonPos(double x, double y) {
        y = window.Height - y;
        return ((x < (buttonX + buttonWidth) && x > (buttonX - buttonWidth)) &&
                (y < (buttonY + buttonHeight) && y > (buttonY - buttonHeight)));
    }
}


