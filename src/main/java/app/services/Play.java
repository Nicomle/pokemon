package app.services;

import app.controllers.KeyBoard;
import app.core.Properties;
import app.graphics.Personaje;

import javax.swing.*;
import java.awt.*;

public class Play extends JFrame implements Runnable {

    private static final String NAME = Properties.name;
    private static volatile boolean run;
    private static int aps = 0;
    private static int fps = 0;

    private static Thread thread;
    private static KeyBoard keyBoard;

    private static Personaje pj;
    private static JPanel pjPanel;

    public Play() {
        setPreferredSize(new Dimension(Properties.width, Properties.height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        keyBoard = new KeyBoard();
        addKeyListener(keyBoard);

        pjPanel = new JPanel();
        pjPanel.setSize(new Dimension(Properties.width, Properties.height));
        pjPanel.setVisible(true);
        add(pjPanel);

        pj = new Personaje("src/main/java/app/sprites/PJ0.png", 'S', false, new Dimension(Properties.pjMediumX, Properties.pjMediumY));
        pjPanel.add(pj.pjLabel);
    }

    @Override
    public void run() {
        final long NS_SECONDS = 1000000000;
        final byte APS_OBJECTIVE = 60;
        final double NS_UPDATE = NS_SECONDS / APS_OBJECTIVE;
        long updateReference = System.nanoTime();
        long counterReference = System.nanoTime();
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
            pj.moveUp();
        }
        if (keyBoard.down) {
            pj.moveDown();
        }
        if (keyBoard.left) {
            pj.moveLeft();
        }
        if (keyBoard.right) {
            pj.moveRight();
        }
        aps++;
    }
}
