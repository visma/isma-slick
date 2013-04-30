package org.isma.slick2d.drawer;

import org.isma.slick2d.GameContext;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledMapDrawer<O, G extends GameContext> extends AbstractDrawer<O, G> {
    protected TiledMapDrawer(G context) {
        super(context);
    }


    public void draw(Graphics g, TiledMap tiledMap, int layerIndex) throws SlickException {
        tiledMap.render(0, 0, 0, 0, tiledMap.getWidth(), tiledMap.getHeight(), layerIndex, true);
    }

}
