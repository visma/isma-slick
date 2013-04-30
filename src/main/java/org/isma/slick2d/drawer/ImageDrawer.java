package org.isma.slick2d.drawer;

import org.isma.slick2d.GameContext;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class ImageDrawer<O, G extends GameContext> extends AbstractDrawer<O, G> {
    public ImageDrawer(G context) {
        super(context);
    }

    public void draw(Image image, float xPos, float yPos, Color filter, O obj) {
        image.draw(xPos, yPos, filter);
    }
}
