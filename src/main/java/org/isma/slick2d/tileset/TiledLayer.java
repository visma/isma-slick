package org.isma.slick2d.tileset;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public abstract class TiledLayer {
    private final int index;
    private final TiledMap tiledMap;

    protected TiledLayer(int index, TiledMap tiledMap) {
        this.index = index;
        this.tiledMap = tiledMap;
    }


    public int getIndex() {
        return index;
    }


    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public Rectangle getRectangle(int x, int y) {
        return new Rectangle(
                (float) x * getTiledMap().getTileWidth(),
                (float) y * getTiledMap().getTileHeight(),
                getTiledMap().getTileWidth(),
                getTiledMap().getTileHeight()
        );
    }


}
