package org.isma.slick2d;

import org.isma.slick2d.resources.GameResourcesLoader;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;

public abstract class ResourcesGame<H extends org.isma.slick2d.resources.ResourcesManager>
        extends StateBasedGame {

    private final GameResourcesLoader resourcesManager;
    protected final H resourcesHanlder;


    public ResourcesGame(String title, String namespace) throws IOException, SlickException {
        super(title);

        resourcesManager = new GameResourcesLoader(namespace);
        resourcesHanlder = buildResourcesHandler(resourcesManager);
    }


    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        loadResources();
    }

    private void loadResources() throws SlickException {
        resourcesHanlder.getConfiguration().loadConfiguration();
        resourcesHanlder.getFontResources().loadFonts();
        resourcesHanlder.getImageResources().loadImages();
        resourcesHanlder.getSoundResources().loadSounds();
    }


    protected abstract H buildResourcesHandler(GameResourcesLoader resourcesManager) throws SlickException;

    public String get(String propertyName) {
        return resourcesManager.get(propertyName);
    }

}
