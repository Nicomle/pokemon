package app.services;

import app.controllers.KeyBoard;
import app.core.Properties;
import app.graphics.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Play extends JFrame implements Runnable {

    private static final String NAME = Properties.name;
    private static volatile boolean run;
    private static int aps = 0;
    private static int fps = 0;

    private static Thread thread;
    private static KeyBoard keyBoard;

    private static Personaje pj = new Personaje("src/main/java/app/sprites/PJ0.png", 'S', false);
    private static BufferedImage imageBuffered;
    private static JPanel pjPanel;
    private static JLabel pjLabel;

    private static int x = Properties.pjMediumX;
    private static int y = Properties.pjMediumY;

    public Play() {
        setPreferredSize(new Dimension(Properties.width, Properties.height));

        keyBoard = new KeyBoard();
        addKeyListener(keyBoard);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        imageBuffered = pj.pj0Down1.getBufferedImage();

        pjPanel = new JPanel();
        pjPanel.setVisible(true);
        add(pjPanel);

        pjLabel = new JLabel();
        pjLabel.setIcon(new ImageIcon(imageBuffered));
        pjLabel.setBounds(x, y, Properties.tamSprite, Properties.tamSprite);
        pjLabel.setVisible(true);
        pjPanel.add(pjLabel);
    }

    @Override
    public void run() {
        final long NS_SECONDS = 1000000000;
        final byte APS_OBJECTIVE = 60;
        final double NS_UPDATE = NS_SECONDS / APS_OBJECTIVE;
        long updateReference = System.nanoTime();
        long counterReference = System.nanoTime();
        ;
        double timeElapsed;
        double delta = 0;
        requestFocus();

        while (run) {
            final long startLoop = System.nanoTime();
            timeElapsed = startLoop - updateReference;
            updateReference = startLoop;
            delta += timeElapsed / NS_UPDATE;

            while (delta >= 1) {
                update();
                delta--;
            }

            fps++;

            if ((System.nanoTime() - counterReference) > NS_SECONDS) {
                setTitle(NAME + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                counterReference = System.nanoTime();
            }
        }
    }

    public synchronized void start() {
        run = true;
        thread = new Thread(this, "Graphics");
        thread.start();
    }

    public synchronized void stop() {
        run = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        if (keyBoard.up) {
            imageBuffered = pj.pj0Up1.getBufferedImage();
            pjLabel.setIcon(new ImageIcon(imageBuffered));
            try {
                for (int i = 0; i < Properties.tamSprite; i++) {
                    y--;
                    Thread.sleep(8);
                    pjLabel.setLocation(x, y);
                    if(i == 16) {
                        imageBuffered = pj.pj0Up2.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 32) {
                        imageBuffered = pj.pj0Up3.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 48) {
                        imageBuffered = pj.pj0Up4.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    }
                }
                imageBuffered = pj.pj0Up1.getBufferedImage();
                pjLabel.setIcon(new ImageIcon(imageBuffered));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (keyBoard.down) {
            imageBuffered = pj.pj0Down1.getBufferedImage();
            pjLabel.setIcon(new ImageIcon(imageBuffered));
            try {
                for (int i = 0; i < Properties.tamSprite; i++) {
                    y++;
                    Thread.sleep(8);
                    pjLabel.setLocation(x, y);
                    if(i == 16) {
                        imageBuffered = pj.pj0Down2.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 32) {
                        imageBuffered = pj.pj0Down3.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 48) {
                        imageBuffered = pj.pj0Down4.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    }
                }
                imageBuffered = pj.pj0Down1.getBufferedImage();
                pjLabel.setIcon(new ImageIcon(imageBuffered));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (keyBoard.left) {
            imageBuffered = pj.pj0Left1.getBufferedImage();
            pjLabel.setIcon(new ImageIcon(imageBuffered));
            try {
                for (int i = 0; i < Properties.tamSprite; i++) {
                    x--;
                    Thread.sleep(8);
                    pjLabel.setLocation(x, y);
                    if(i == 16) {
                        imageBuffered = pj.pj0Left2.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 32) {
                        imageBuffered = pj.pj0Left3.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 48) {
                        imageBuffered = pj.pj0Left4.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    }
                }
                imageBuffered = pj.pj0Left1.getBufferedImage();
                pjLabel.setIcon(new ImageIcon(imageBuffered));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (keyBoard.right) {
            imageBuffered = pj.pj0Right1.getBufferedImage();
            pjLabel.setIcon(new ImageIcon(imageBuffered));
            try {
                for (int i = 0; i < Properties.tamSprite; i++) {
                    x++;
                    Thread.sleep(8);
                    pjLabel.setLocation(x, y);
                    if(i == 16) {
                        imageBuffered = pj.pj0Right2.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 32) {
                        imageBuffered = pj.pj0Right3.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    } else if (i == 48) {
                        imageBuffered = pj.pj0Right4.getBufferedImage();
                        pjLabel.setIcon(new ImageIcon(imageBuffered));
                    }
                }
                imageBuffered = pj.pj0Right1.getBufferedImage();
                pjLabel.setIcon(new ImageIcon(imageBuffered));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        aps++;
    }
}
