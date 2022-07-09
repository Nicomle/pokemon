package app.graphics;

import javax.swing.*;

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

    public Personaje(final String ruta, final char pos, boolean move) {
        this.initSprites(ruta);
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
}
