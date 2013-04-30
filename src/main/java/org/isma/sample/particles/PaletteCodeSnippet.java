package org.isma.sample.particles;

import java.awt.*;

public class PaletteCodeSnippet {
    public static void main(String[] args) {
        //A voir avec une version plus recente de slick
        /*
        final BufferedImage source = new Store("data/sheets").newBufferedImage("garbage.png");
        final WritableRaster clone = source.copyData(null);
        final DataBufferInt dataBuffer = (DataBufferInt) clone.getDataBuffer();

        final ImageBuffer destinationbuffer = new ImageBuffer(source.getWidth(), source.getHeight());
        for (int y = 0; y < destinationbuffer.getHeight(); y++) {
            for (int x = 0; x < destinationbuffer.getWidth(); x++) {
                // Base color is always blue
                final Color pixel = new Color(dataBuffer.getData()[x + (y * destinationbuffer.getWidth())]);
                final float[] hsbColor = java.awt.Color.RGBtoHSB(pixel.getRed(), pixel.getGreen(), pixel.getBlue(), null);
                final Color rgbColor = new Color(java.awt.Color.HSBtoRGB(palette.getHue(), hsbColor[1], hsbColor[2]));
                destinationbuffer.setRGBA(x, y, rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue(), rgbColor.getAlpha());
            }
        }
        sheet = Store.newSpriteSheet(destinationbuffer.getImage(), WIDTH, HEIGHT);
        */
    }

    public enum Palette {
        BLUE(Color.BLUE), //
        RED(Color.RED), //
        GREEN(Color.GREEN), //
        YELLOW(Color.YELLOW), //
        PINK(0.9F), //
        ORANGE(Color.ORANGE), //
        MAGENTA(Color.MAGENTA), //
        CYAN(Color.CYAN);

        private final float hue;

        private Palette(final Color color) {
            this(Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0]);
        }

        private Palette(final float hue) {
            this.hue = hue;
        }

        public final float getHue() {
            return hue;
        }
    }
}
