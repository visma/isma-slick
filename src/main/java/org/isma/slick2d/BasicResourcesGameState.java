package org.isma.slick2d;

import org.newdawn.slick.*;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static org.newdawn.slick.Input.KEY_F;

public abstract class BasicResourcesGameState<C extends GameContext> extends BasicGameState {
    private final C gameContext;

    protected BasicResourcesGameState(C gameContext) throws SlickException {
        this.gameContext = gameContext;
    }


    protected C getContext() {
        return gameContext;
    }

    public final void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        handleInputs(container, game);
        if (isGameUpdateSuspended()) {
            return;
        }
        doUpdate(container, game, delta);
    }

    private int screenshotNum = 0;

    public final void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        prepareGraphicsTransformation(g, getContext());

        doRender(container, game, g);

        if (captureScreen(container.getInput())) {
            printScreen(g, "screenshot_" + screenshotNum++ + ".jpg");
        }
    }

    protected boolean captureScreen(Input input) {
        return false;
    }

    protected void prepareGraphicsTransformation(Graphics g, GameContext context) {
        float zoomRatio = 1f;
        if (enableZoom()) {
            zoomRatio = context.getZoomRatio();
        }
        float xPos = context.getGameScreenXPosition(zoomRatio);
        float yPos = context.getGameScreenYPosition(zoomRatio);

        //Important : translate et APRES scale
        g.translate(xPos, yPos);
        if (enableZoom()) {
            g.scale(zoomRatio, zoomRatio);
        }
    }

    protected boolean enableZoom() {
        return false;
    }

    protected abstract void doRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;


    protected abstract void doUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException;


    protected boolean isGameUpdateSuspended() {
        return false;
    }


    protected void handleInputs(GameContainer container, StateBasedGame game) throws SlickException {
        if (container.getInput().isKeyDown(KEY_F)) {
            container.setFullscreen(!container.isFullscreen());
        }
    }

    private void printScreen(Graphics g, String fname) throws SlickException {
        Image screenshot = new Image(gameContext.getScreenSize().width, gameContext.getScreenSize().height);
        g.drawImage(screenshot, 0, 0);
        g.copyArea(screenshot, 0, 0);
        ImageOut.write(screenshot, fname);
    }


}
