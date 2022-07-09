package app.graphics;

import app.core.Properties;

import java.awt.image.BufferedImage;

public class Sprite {

    private final BufferedImage imageBuffered;

    public Sprite(final int column, final int row, final SpriteSheet sheet) {
        imageBuffered = sheet.getBufferedImage()
                .getSubimage(column * Properties.tamSprite, row * Properties.tamSprite,
                        Properties.tamSprite, Properties.tamSprite);
    }

    public BufferedImage getBufferedImage() {
        return imageBuffered;
    }
}
