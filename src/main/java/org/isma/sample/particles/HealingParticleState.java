package org.isma.sample.particles;

import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static java.lang.ClassLoader.getSystemResource;

public class HealingParticleState extends BasicGameState {
	
	private ParticleSystem system;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		//load the plus particle and create a particle system with a limit of 1500 particles
		Image image = new Image("data/particle_plus.png", false);
		system = new ParticleSystem(image,1500);
 
		try {
			//load the xml file and add the emitter to the system
            File xmlFile = new File(getSystemResource("data/healing.xml").toURI());

			ConfigurableEmitter emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(315, 358);
			system.addEmitter(emitter);
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
 
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		//update the system and its emitters
		system.update(delta);
		
		if(gc.getInput().isKeyPressed(Input.KEY_1)){
			sbg.enterState(1);
		}else if(gc.getInput().isKeyPressed(Input.KEY_2)){
			sbg.enterState(2);
		}else if(gc.getInput().isKeyPressed(Input.KEY_3)){
			sbg.enterState(3);
		}
	}
	
	public void keyPressed(int key, char code){
		if(key == Input.KEY_ESCAPE){
			System.exit(0);
		}
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Healing Particle", 10, 25);
		
		//render the particle system
		system.render();
	}
	
	public int getID() {
		return 3;
	}

}
