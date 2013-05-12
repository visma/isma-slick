package org.isma.slick2d.drawer;

import org.isma.slick2d.context.GameContext;

public abstract class AbstractDrawer<O extends Object, G extends GameContext> {
    protected final G context;

    protected AbstractDrawer(G context) {
        this.context = context;
    }

}
