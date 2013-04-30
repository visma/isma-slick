package org.isma.slick2d.font;

import org.newdawn.slick.Color;

public class CharColored {
    private char character;
    private Color color;

    CharColored(char character, Color color) {
        this.character = character;
        this.color = color;
    }

    public String getCharacter() {
        return Character.toString(character);
    }

    public Color getColor() {
        return color;
    }
}
