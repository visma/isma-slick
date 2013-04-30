package org.isma.slick2d.font;

import org.newdawn.slick.Color;

import java.util.ArrayList;
import java.util.List;

public class ColoredText {
    private final List<CharColored> chars = new ArrayList<CharColored>();

    public void add(char c, Color color) {
        chars.add(new CharColored(c, color));
    }

    public void addAll(char[] toConcat, Color color) {
        for (char c : toConcat) {
            add(c, color);
        }
    }

    public List<CharColored> getCharsColored() {
        return chars;
    }

    public String getText() {
        String text = "";
        for (CharColored aChar : chars) {
            text += aChar.getCharacter();
        }
        return text;
    }

    public void concat(ColoredText other) {
        chars.addAll(other.chars);
    }

    public void concat(int text, Color color) {
        addAll(Integer.toString(text).toCharArray(), color);
    }

    public void concat(char text, Color color) {
        addAll(Character.toString(text).toCharArray(), color);
    }

    public void concat(String text, Color color) {
        addAll(text.toCharArray(), color);
    }

    public void concat(long text, Color color) {
        addAll(Long.toString(text).toCharArray(), color);
    }
}
