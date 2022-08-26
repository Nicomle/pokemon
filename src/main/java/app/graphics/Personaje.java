package app.graphics;

import app.core.Properties;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Personaje {

    public SpriteSheet pjSS;
    public Sprite pj0Down1;
    public Sprite pj0Down2;
    public Sprite pj0Down3;
    public Sprite pj0Down4;
    public Sprite pj0Left1;
    public Sprite pj0Left2;
    public Sprite pj0Left3;
    public Sprite pj0Left4;
    public Sprite pj0Right1;
    public Sprite pj0Right2;
    public Sprite pj0Right3;
    public Sprite pj0Right4;
    public Sprite pj0Up1;
    public Sprite pj0Up2;
    public Sprite pj0Up3;
    public Sprite pj0Up4;
    public JLabel pjLabel;
    public BufferedImage bufferedImage;
    public int x;
    public int y;

    public Personaje(final String ruta, final char pos, boolean move, Dimension dimension) {
        this.x = dimension.width;
        this.y = dimension.height;
        this.initSprites(ruta);
        this.initLabel(pos);
    }

    private void initSprites(final String ruta) {
        this.pjSS = new SpriteSheet(ruta);
        this.pj0Down1 = new Sprite(0, 0, this.pjSS);
        this.pj0Down2 = new Sprite(1, 0, this.pjSS);
        this.pj0Down3 = new Sprite(2, 0, this.pjSS);
        this.pj0Down4 = new Sprite(3, 0, this.pjSS);
        this.pj0Left1 = new Sprite(0, 1, this.pjSS);
        this.pj0Left2 = new Sprite(1, 1, this.pjSS);
        this.pj0Left3 = new Sprite(2, 1, this.pjSS);
        this.pj0Left4 = new Sprite(3, 1, this.pjSS);
        this.pj0Right1 = new Sprite(0, 2, this.pjSS);
        this.pj0Right2 = new Sprite(1, 2, this.pjSS);
        this.pj0Right3 = new Sprite(2, 2, this.pjSS);
        this.pj0Right4 = new Sprite(3, 2, this.pjSS);
        this.pj0Up1 = new Sprite(0, 3, this.pjSS);
        this.pj0Up2 = new Sprite(1, 3, this.pjSS);
        this.pj0Up3 = new Sprite(2, 3, this.pjSS);
        this.pj0Up4 = new Sprite(3, 3, this.pjSS);
    }

    private void initLabel(char pos) {
        pjLabel = new JLabel();
        if(pos == 'N') {
            bufferedImage = pj0Up1.bufferedImage;
        } else if (pos == 'S') {
            bufferedImage = pj0Down1.bufferedImage;
        } else if (pos == 'W') {
            bufferedImage = pj0Left1.bufferedImage;
        } else if (pos == 'E') {
            bufferedImage = pj0Right1.bufferedImage;
        }
        pjLabel.setBounds(x, y, Properties.tamSprite, Properties.tamSprite);
        pjLabel.setIcon(new ImageIcon(bufferedImage));
        pjLabel.setVisible(true);
    }

    public void moveUp() {
        bufferedImage = pj0Up1.bufferedImage;
        pjLabel.setIcon(new ImageIcon(bufferedImage));
        try {
            for (int i = 0; i < Properties.tamSprite; i++) {
                y--;
                pjLabel.setLocation(x, y);
                if (i == 16) {
                    bufferedImage = pj0Up2.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 32) {
                    bufferedImage = pj0Up3.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 48) {
                    bufferedImage = pj0Up4.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                }
                Thread.sleep(5);
            }
            bufferedImage = pj0Up1.bufferedImage;
            pjLabel.setIcon(new ImageIcon(bufferedImage));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveDown() {
        bufferedImage = pj0Down1.bufferedImage;
        pjLabel.setIcon(new ImageIcon(bufferedImage));
        try {
            for (int i = 0; i < Properties.tamSprite; i++) {
                y++;
                pjLabel.setLocation(x, y);
                if (i == 16) {
                    bufferedImage = pj0Down2.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 32) {
                    bufferedImage = pj0Down3.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 48) {
                    bufferedImage = pj0Down4.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                }
                Thread.sleep(5);
            }
            bufferedImage = pj0Down1.bufferedImage;
            pjLabel.setIcon(new ImageIcon(bufferedImage));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveLeft() {
        bufferedImage = pj0Left1.bufferedImage;
        pjLabel.setIcon(new ImageIcon(bufferedImage));
        try {
            for (int i = 0; i < Properties.tamSprite; i++) {
                x--;
                pjLabel.setLocation(x, y);
                if (i == 16) {
                    bufferedImage = pj0Left2.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 32) {
                    bufferedImage = pj0Left3.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 48) {
                    bufferedImage = pj0Left4.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                }
                Thread.sleep(5);
            }
            bufferedImage = pj0Left1.bufferedImage;
            pjLabel.setIcon(new ImageIcon(bufferedImage));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveRight() {
        bufferedImage = pj0Right1.bufferedImage;
        pjLabel.setIcon(new ImageIcon(bufferedImage));
        try {
            for (int i = 0; i < Properties.tamSprite; i++) {
                x++;
                pjLabel.setLocation(x, y);
                if (i == 16) {
                    bufferedImage = pj0Right2.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 32) {
                    bufferedImage = pj0Right3.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                } else if (i == 48) {
                    bufferedImage = pj0Right4.bufferedImage;
                    pjLabel.setIcon(new ImageIcon(bufferedImage));
                }
                Thread.sleep(5);
            }
            bufferedImage = pj0Right1.bufferedImage;
            pjLabel.setIcon(new ImageIcon(bufferedImage));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
