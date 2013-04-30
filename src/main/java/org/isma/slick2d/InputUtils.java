package org.isma.slick2d;

import org.newdawn.slick.Input;

import static org.newdawn.slick.Input.*;

public class InputUtils {
    public static String inputToString(Integer inputCode) {
        if (inputCode == null) {
            return null;
        }
        if (inputCode == KEY_DOWN) {
            return "down";
        }
        if (inputCode == KEY_UP) {
            return "up";
        }
        if (inputCode == KEY_RIGHT) {
            return "right";
        }
        if (inputCode == KEY_LEFT) {
            return "left";
        }
        return null;
    }

    public static String inputToString(Input input) {
        if (input == null) {
            return null;
        }
        if (input.isKeyDown(KEY_DOWN)) {
            return "down";
        }
        if (input.isKeyDown(KEY_UP)) {
            return "up";
        }
        if (input.isKeyDown(KEY_RIGHT)) {
            return "right";
        }
        if (input.isKeyDown(KEY_LEFT)) {
            return "left";
        }
        return null;
    }
}
