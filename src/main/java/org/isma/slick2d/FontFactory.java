package org.isma.slick2d;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;

public class FontFactory {

    public static UnicodeFont buildFont(String ttfFile, Color color) throws SlickException {
        UnicodeFont uFont = new UnicodeFont(ttfFile, 20, true, false);
        uFont.addAsciiGlyphs();
        uFont.getEffects().add(new ColorEffect(color));
        uFont.loadGlyphs();
        return uFont;
    }
}
