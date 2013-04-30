package org.isma.slick2d.drawer;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import static java.lang.System.currentTimeMillis;

public abstract class ParticleDrawer<O> {
    private ParticleSystem system;
    private ConfigurableEmitter emitter;
    private long lastTime = 0;

    protected ParticleDrawer(String imageRef, String xmlEmitterFile) throws SlickException {
        initParticles(imageRef, xmlEmitterFile);
    }

    private void initParticles(String imageRef, String xmlEmitterFile) throws SlickException {
        try {
            Image image = new Image(imageRef, false);
            system = new ParticleSystem(image, 1500);
            emitter = ParticleIO.loadEmitter(xmlEmitterFile);
            system.addEmitter(emitter);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
    }

    protected abstract boolean render(O obj);

    protected abstract Vector2f getCenterOffSet(O obj);


    public boolean renderParticles(O obj, float xPos, float yPos) {
        long delta = getDelta();
        Vector2f offset = getCenterOffSet(obj);

        emitter.setPosition(xPos + offset.getX(), yPos + offset.y);
        system.update((int) delta);

        if (render(obj)) {
            system.render();
        }
        return render(obj);
    }


    private long getDelta() {
        long delta;
        if (lastTime == 0) {
            lastTime = currentTimeMillis();
            return 0;
        } else {
            delta = currentTimeMillis() - lastTime;
            lastTime = currentTimeMillis();
            return delta;
        }
    }

}
