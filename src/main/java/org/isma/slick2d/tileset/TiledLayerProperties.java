package org.isma.slick2d.tileset;

//TODO fusionner avec TiledLayer, ça m'a l'air de servir a rien (et en plus ça fait un cycle)
public abstract class TiledLayerProperties {
    protected final TiledLayer owner;

    protected TiledLayerProperties(final TiledLayer owner) {
        this.owner = owner;
    }
}
