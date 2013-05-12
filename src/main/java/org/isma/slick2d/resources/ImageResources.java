package org.isma.slick2d.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class ImageResources {
    private final GameResourcesLoader resourcesManager;

    protected final Map<String, SpriteSheet> sprites = new HashMap<String, SpriteSheet>();
    protected final Map<String, Image> images = new HashMap<String, Image>();


    protected ImageResources(GameResourcesLoader resourcesManager) {
        this.resourcesManager = resourcesManager;
    }

    public abstract void loadImages() throws SlickException;

    protected void loadImage(String property) throws SlickException {
        String imagePath = resourcesManager.get(property);
        System.out.printf("loading image %s  ...\n", imagePath);
        images.put(property, new Image(imagePath));
    }

    protected void loadSprite(String propertyName, Dimension dimension) throws SlickException {
        String filepath = resourcesManager.get(propertyName);
        System.out.printf("loading sprite %s  ...\n", filepath);
        sprites.put(propertyName, new SpriteSheet(filepath, dimension.width, dimension.height));
    }


}
