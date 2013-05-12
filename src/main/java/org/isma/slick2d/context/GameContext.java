package org.isma.slick2d.context;


import java.awt.*;

public interface GameContext<H extends org.isma.slick2d.resources.ResourcesManager> {

    float getGameScreenXPosition(float zoomRatio);

    float getGameScreenYPosition(float zoomRatio);

    Dimension getScreenSize();

    Dimension getGameScreenSize(float zoomRatio);

    String get(String propertyName);

    H getResourcesManager();

    boolean isDebugMode();

    float getZoomRatio();


}
