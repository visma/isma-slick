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

public class ParticleState extends BasicGameState {
	private ParticleSystem system;
	private ConfigurableEmitter emitter;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		try {
			//load the test particle and 
			Image image = new Image("data/test_particle.png", false);
			system = new ParticleSystem(image,1500);

            File xmlFile = new File(getSystemResource("data/test_emitter.xml").toURI());
            System.out.println(xmlFile.getAbsolutePath());

			emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(400, 300);
			system.addEmitter(emitter);
		} catch (Exception e) {
            e.printStackTrace();
			System.exit(0);
		}
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		system.update(delta);
		
		
		//move the particle emitter left and right but never both simultaneously 
		if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
			emitter.setPosition(emitter.getX()-((float)delta/8),emitter.getY());
		}else if(gc.getInput().isKeyDown(Input.KEY_RIGHT)){
			emitter.setPosition(emitter.getX()+((float)delta/8),emitter.getY());
		}
		
		//move the particle emitter up and down but never simultaneously
		if(gc.getInput().isKeyDown(Input.KEY_UP)){
			emitter.setPosition(emitter.getX(),emitter.getY()-((float)delta/8));
		}else if(gc.getInput().isKeyDown(Input.KEY_DOWN)){
			emitter.setPosition(emitter.getX(),emitter.getY()+((float)delta/8));
		}
		
		//switch states
		if(gc.getInput().isKeyPressed(Input.KEY_1)){
			sbg.enterState(1);
		}else if(gc.getInput().isKeyPressed(Input.KEY_2)){
			sbg.enterState(2);
		}else if(gc.getInput().isKeyPressed(Input.KEY_3)){
			sbg.enterState(3);
		}
	}
	
	public void mousePressed(int button, int x, int y){
		//when we click somewhere, change the emitters position
		emitter.setPosition(x, y);
	}
	
	public void keyPressed(int key, char code){
		if(key == Input.KEY_SPACE){
			
			//when we press the spacebar, create a new system with the possibly altered image file and emitter
			try {
				Image image = new Image("data/test_particle.png", false);
				system = new ParticleSystem(image,1500);

                File xmlFile = new File(getSystemResource("data/test_emitter.xml").toURI());
				emitter = ParticleIO.loadEmitter(xmlFile);
				emitter.setPosition(400, 300);
				system.addEmitter(emitter);
			} catch (Exception e) {
				System.exit(0);
                e.printStackTrace();
			}
			system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);	
		}
		
		//escape means, close the program
		if(key == Input.KEY_ESCAPE){
			System.exit(0);
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Test Particle | Particle count: " + system.getParticleCount(), 10, 25);
		g.drawString("Press spacebar to reload and click to relocate emitter, arrow keys to move it around", 10, 40);
		g.drawString("It reloads the following files: \"data/test_emitter.xml\" and \"data/test_particle.png\"", 10, 55);
		system.render();
	}

	public int getID() {
		return 1;
	}

}
