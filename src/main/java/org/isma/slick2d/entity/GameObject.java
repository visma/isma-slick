package org.isma.slick2d.entity;

import org.isma.slick2d.context.GameContext;

public abstract class GameObject<G extends GameContext> {
    protected final G context;

    protected GameObject(G context) {
        this.context = context;
    }

    protected G getContext() {
        return context;
    }
}
