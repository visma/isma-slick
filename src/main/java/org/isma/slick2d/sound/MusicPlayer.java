package org.isma.slick2d.sound;

import org.newdawn.slick.Music;


public class MusicPlayer {
    private Music currentlyPlayed;


    public void loop(Music music) {
        if (currentlyPlay(music)) {
            return;
        }
        currentlyPlayed.loop();
    }

    public void play(Music music) {
        if (currentlyPlay(music)) {
            return;
        }
        currentlyPlayed.play();
    }

    private boolean currentlyPlay(Music music) {
        if (music == currentlyPlayed) {
            return true;
        }
        if (currentlyPlayed != null) {
            currentlyPlayed.stop();
        }
        currentlyPlayed = music;
        return false;
    }

    public void stop() {
        if (currentlyPlayed != null) {
            currentlyPlayed.stop();
            currentlyPlayed = null;
        }
    }
}
