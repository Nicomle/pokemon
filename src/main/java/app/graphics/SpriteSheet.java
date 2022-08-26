package app.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class SpriteSheet {

    public BufferedImage bufferedImage;

    public SpriteSheet(final String ruta) {
        try {
            bufferedImage = ImageIO.read(new FileInputStream(ruta));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
