package org.isma.slick2d.drawer;

import org.isma.slick2d.GameContext;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;

public class RenderableDrawer<O, G extends GameContext> extends AbstractDrawer<O, G> {

    public RenderableDrawer(G context) {
        super(context);
    }

    public void draw(Renderable renderable, float xPos, float yPos, Color filter, O obj) {
        if (renderable instanceof Animation) {
            Animation animation = (Animation) renderable;
            drawAnimation(xPos, yPos, filter, animation, obj);
        } else if (renderable instanceof Image) {
            Image image = (Image) renderable;
            drawImage(xPos, yPos, filter, image, obj);
        }

    }

    protected void drawImage(float xPos, float yPos, Color filter, Image image, O obj) {
        image.draw(xPos, yPos, filter);
    }

    protected void drawAnimation(float xPos, float yPos, Color filter, Animation animation, O obj) {
        animation.draw(xPos, yPos, animation.getWidth(), animation.getHeight(), filter);
    }

}
