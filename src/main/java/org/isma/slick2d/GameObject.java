package org.isma.slick2d;

public abstract class GameObject<G extends GameContext> {
    protected final G context;

    protected GameObject(G context) {
        this.context = context;
    }

    protected G getContext() {
        return context;
    }
}
