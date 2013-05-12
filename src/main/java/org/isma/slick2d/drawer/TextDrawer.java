package org.isma.slick2d.drawer;

import org.isma.slick2d.context.GameContext;
import org.isma.slick2d.font.CharColored;
import org.isma.slick2d.font.ColoredText;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;

public class TextDrawer<O, G extends GameContext> extends AbstractDrawer<O, G> {

    public TextDrawer(G context) {
        super(context);
    }


    public void draw(Font font, float x, float y, Color color, String text) {
        font.drawString(x, y, text, color);
    }

    public void drawCenter(Font font, float y, Color color, float zoomRatio, String text) {
        int screenWidth = context.getGameScreenSize(zoomRatio).width;
        float textWidth = font.getWidth(text) * zoomRatio;

        float x = (screenWidth - textWidth) / 2;
        draw(font, x, y, color, text);
    }

    public void drawCenter(Font font, float y, float zoomRatio, ColoredText text) {
        String textValue = text.getText();

        int screenWidth = context.getGameScreenSize(zoomRatio).width;
        float textWidth = font.getWidth(textValue) * zoomRatio;

        float x = (screenWidth - textWidth) / 2;

        for (CharColored charColored : text.getCharsColored()) {
            float charWidth = font.getWidth(charColored.getCharacter()) * zoomRatio;
            Color color = charColored.getColor();
            String character = charColored.getCharacter();
            draw(font, x, y, color, character);
            x += charWidth;
        }
    }

}
