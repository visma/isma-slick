package org.isma.slick2d.resources;

public interface ResourcesManager<I extends ImageResources, S extends SoundResources, F extends FontResources, C extends Configuration> {
    I getImageResources();

    S getSoundResources();

    F getFontResources();

    C getConfiguration();

}
