package org.isma.slick2d.tileset;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public abstract class TiledLayer<P extends TiledLayerProperties> {
    private final int index;
    private final P properties;
    private final TiledMap tiledMap;

    protected TiledLayer(int index, TiledMap tiledMap) {
        this.index = index;
        this.tiledMap = tiledMap;
        properties = buildProperties();
    }

    protected abstract P buildProperties();

    public int getIndex() {
        return index;
    }

    public P properties() {
        return properties;
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
