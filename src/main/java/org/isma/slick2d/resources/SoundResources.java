package org.isma.slick2d.resources;

import org.isma.slick2d.sound.MusicPlayer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public abstract class SoundResources {
    protected final MusicPlayer musicPlayer = new MusicPlayer();
    protected final GameResourcesLoader resourcesManager;

    protected SoundResources(GameResourcesLoader resourcesManager) {
        this.resourcesManager = resourcesManager;
    }

    public abstract void loadSounds() throws SlickException;

    protected Music loadMusic(String propertyName) throws SlickException {
        String soundFile = resourcesManager.get(propertyName);
        System.out.printf("loading music %s\n", soundFile);
        return new Music(soundFile);
    }

    protected Sound loadSound(String propertyName) throws SlickException {
        String soundFile = resourcesManager.get(propertyName);
        System.out.printf("loading sound %s\n", soundFile);
        return new Sound(soundFile);
    }

    public void stopMusic() {
        musicPlayer.stop();
    }


}
