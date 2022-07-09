package app.core;

import java.awt.*;

public class Properties {

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = screenSize.width;
    public static final int height = screenSize.height;
    public static final String name = "Pokemon";

    public static int tamSprite = 64;
    public static int pjMediumX = (width / 2) - (tamSprite / 2);
    public static int pjMediumY = (height / 2) - (tamSprite / 2);
}
