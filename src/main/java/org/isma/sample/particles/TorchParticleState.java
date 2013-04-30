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

public class TorchParticleState extends BasicGameState {

    private ParticleSystem system;
	private Image wallImage;
	private Image torch;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		wallImage = new Image("data/wall_dark.png");
		torch = new Image("data/torch.png");
		
		Image image = new Image("data/particle.png", false);
		system = new ParticleSystem(image,1500);
 
		try {
            File xmlFile = new File(getSystemResource("data/torch.xml").toURI());

			ConfigurableEmitter emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(315, 358);
			system.addEmitter(emitter);
			emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(465, 358);
			system.addEmitter(emitter);
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
 
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
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
		g.drawString("Torch Particle", 10, 25);
		
		for(int x = 200; x < 600; x += 32){
			for(int y = 300; y < 397; y += 32){
				wallImage.draw(x,y);
			}
		}
		
		torch.draw(300,350);
		torch.draw(450,350);
		
		system.render();
	}
	
	public int getID() {
		return 2;
	}

}
