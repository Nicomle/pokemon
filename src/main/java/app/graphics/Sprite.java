package app.graphics;

import app.core.Properties;

import java.awt.image.BufferedImage;

public class Sprite {

    public final BufferedImage bufferedImage;

    public Sprite(final int column, final int row, final SpriteSheet sheet) {
        bufferedImage = sheet.bufferedImage
                .getSubimage(column * Properties.tamSprite, row * Properties.tamSprite,
                        Properties.tamSprite, Properties.tamSprite);
    }
}
