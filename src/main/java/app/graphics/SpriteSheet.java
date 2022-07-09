package app.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class SpriteSheet {

    private BufferedImage imageBuffered;

    public SpriteSheet(final String ruta) {
        try {
            imageBuffered = ImageIO.read(new FileInputStream(ruta));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        return imageBuffered;
    }
}
