package com.rekaerst;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class App extends Canvas implements Runnable {

    private static final long serialVersionUID = 951988467320086772L;

    private static String OS = null;

    private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private static final String TITLE = "JRocket Game";

    private Thread thread;
    private boolean running = false;

    private Handler handler;

    public App() {
        if (isLinux()) {
            System.setProperty("sun.java2d.opengl", "true");
        }
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, TITLE, this);

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join(); // kill the thread
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                ticks();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void ticks() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // if (isLinux()) {
        // Toolkit.getDefaultToolkit().sync();
        // }
        handler.render(g);

        g.dispose();
        bs.show();
    }

    public String getOSName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    public boolean isWindows() {
        return getOSName().startsWith("Windows");
    }

    public boolean isLinux() {
        return getOSName().startsWith("Linux");
    }

    public static void main(String[] args) {

        new App();
    }
}
