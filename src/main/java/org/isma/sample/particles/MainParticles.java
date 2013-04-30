package org.isma.sample.particles;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainParticles extends StateBasedGame {

    public MainParticles(String name) {
        super(name);
    }

    public void initStatesList(GameContainer arg0) throws SlickException {

        //create the states and add them to the game
        addState(new TorchParticleState());
        addState(new ParticleState());
        addState(new HealingParticleState());

        enterState(1);
    }

    public static void main(String args[]) throws SlickException {
        AppGameContainer app = new AppGameContainer(new MainParticles("Particle Effects"));
        app.setDisplayMode(800, 600, false);

        //always render the application, even if we don't focus it
        app.setAlwaysRender(true);
        app.start();

    }

}
