package org.isma.slick2d;

import org.isma.slick2d.drawer.RenderableDrawer;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;
import java.util.Map;


public abstract class BitmapObject<R extends Renderable, G extends GameContext> extends GameObject<G> {
    protected SpriteSheet sprite;
    protected float x;
    protected float y;
    protected final Map<Object, R> renderables = new HashMap<Object, R>();
    private RenderableDrawer defaultDrawer;

    protected BitmapObject(G context, float x, float y) {
        super(context);
        this.x = x;
        this.y = y;
    }

    public void init() throws SlickException {
        sprite = getSpriteSheet();
        buildRenderables();
    }

    protected abstract void buildRenderables();

    protected abstract SpriteSheet getSpriteSheet();

    protected abstract int getWidth();

    protected abstract int getHeight();

    public void draw() {
        draw(defaultDrawer);
    }

    public void draw(RenderableDrawer drawer) {
        Renderable renderable = renderables.get(getRenderableKey());
        if (renderable == null) {
            renderable = renderables.get(getDefaultRenderableKey());
        }
        drawer.draw(renderable, getX(), getY(), null, this);
    }


    //TODO manque d'élégance : repenser un peu les méthodes draw...
    public void draw(RenderableDrawer drawer, float aX, float aY) {
        float oldX = this.x;
        float oldY = this.y;
        this.x = aX;
        this.y = aY;

        draw(drawer);

        this.x = oldX;
        this.y = oldY;
    }


    protected abstract Object getRenderableKey();

    protected Object getDefaultRenderableKey() {
        return null;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitmapObject)) return false;

        BitmapObject that = (BitmapObject) o;

        if (Float.compare(that.x, x) != 0) return false;
        if (Float.compare(that.y, y) != 0) return false;
        if (renderables != null ? !renderables.equals(that.renderables) : that.renderables != null) return false;
        if (sprite != null ? !sprite.equals(that.sprite) : that.sprite != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = sprite != null ? sprite.hashCode() : 0;
        result = 31 * result + (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + (renderables != null ? renderables.hashCode() : 0);
        return result;
    }

    public void setDefaultDrawer(RenderableDrawer defaultDrawer) {
        this.defaultDrawer = defaultDrawer;
    }
}
