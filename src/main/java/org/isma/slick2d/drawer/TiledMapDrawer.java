package org.isma.slick2d.drawer;

import org.isma.slick2d.context.GameContext;
import org.isma.slick2d.tileset.TiledObject;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledMapDrawer<T extends TiledObject, G extends GameContext> extends AbstractDrawer<T, G> {
    protected TiledMapDrawer(G context) {
        super(context);
    }


    public void draw(Graphics g, T tiledObject, int layerIndex) throws SlickException {
        TiledMap tiledMap = tiledObject.getTiledMap();
        tiledMap.render(0, 0, 0, 0, tiledMap.getWidth(), tiledMap.getHeight(), layerIndex, true);
    }

}
