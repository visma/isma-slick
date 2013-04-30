package org.isma.slick2d.tileset;

import org.isma.slick2d.GameContext;
import org.isma.slick2d.GameObject;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public abstract class TiledObject<G extends GameContext> extends GameObject<G> {
    private TiledMap tiledMap;
    private Rectangle bounds;
    private Rectangle tilesBounds;

    protected TiledObject(G gameContext) {
        super(gameContext);
    }

    public void loadTiledMap() throws SlickException {
        String tiledMapFile = getContext().get(getTiledMapPropertyName());
        tiledMap = new TiledMap(tiledMapFile);
        if (tiledMap.getTileWidth() != tiledMap.getTileHeight()) {
            throw new RuntimeException("tiles are not squares !");
        }
        bounds = new Rectangle(0, 0,
                tiledMap.getWidth() * tiledMap.getTileWidth(),
                tiledMap.getHeight() * tiledMap.getTileHeight());
        tilesBounds = new Rectangle(0, 0,
                tiledMap.getWidth(),
                tiledMap.getHeight());
    }


    protected abstract String getTiledMapPropertyName();

    public Rectangle getBounds() {
        return bounds;
    }

    public Rectangle getTilesBounds() {
        return tilesBounds;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }


}
