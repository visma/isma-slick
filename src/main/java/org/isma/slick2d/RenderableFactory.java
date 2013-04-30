package org.isma.slick2d;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class RenderableFactory {

    public static Image buildImage(SpriteSheet spriteSheet, float rotateAngle) {
        Image image = spriteSheet.getSprite(0, 0);
        image.rotate(rotateAngle);
        return image;
    }

    public static Animation buildAnimation(SpriteSheet spriteSheet, int amount, int duration, float rotateAngle) {
        return buildAnimation(spriteSheet, amount, duration, rotateAngle, 0, 0, true);
    }

    public static Animation buildAnimation(SpriteSheet spriteSheet, int amount, int duration, float rotateAngle, int xOffSet, int yOffSet, boolean horizontalAnimation) {
        Animation animation = new Animation();
        animation.setAutoUpdate(true);
        for (int frame = 0; frame < amount; frame++) {
            Image sprite;
            if (horizontalAnimation) {
                sprite = spriteSheet.getSprite(frame + xOffSet, yOffSet);
            } else {
                sprite = spriteSheet.getSprite(xOffSet, frame + yOffSet);
            }
            sprite.rotate(rotateAngle);
            animation.addFrame(sprite, duration);
        }
        return animation;
    }

    public static Animation flippedAnimation(Animation animation) {
        Animation flipped = new Animation();
        for (int i = 0; i < animation.getFrameCount(); i++) {
            Image flippedCopy = animation.getImage(i).getFlippedCopy(true, false);
            flipped.addFrame(flippedCopy, animation.getDuration(i));
        }
        return flipped;
    }

    public static Animation buildAnimation(Animation animation, int... frames) {

        Animation newAnim = new Animation();
        for (int frame : frames) {
            newAnim.addFrame(animation.getImage(frame), animation.getDuration(frame));
        }
        return newAnim;
    }
}
