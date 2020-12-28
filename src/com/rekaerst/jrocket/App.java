package com.rekaerst.jrocket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.rekaerst.jrocket.gameObjects.GameObject;
import com.rekaerst.jrocket.gameObjects.ID;
import com.rekaerst.jrocket.gameObjects.Planet;
import com.rekaerst.jrocket.gameObjects.Rocket;
import com.rekaerst.jrocket.gameObjects.Sun;

public class App extends Canvas implements Runnable {

    private static final long serialVersionUID = 951988467320086772L;

    private static String OS = null;

    public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;
    public static final String TITLE = "JRocket Game";

    private Thread thread;
    private boolean running = false;

    private World world;
    private HUD hud;

    public static long test = 0;

    public App() {
        if (isLinux()) {
            System.setProperty("sun.java2d.opengl", "true");
        }
        world = new World();

        this.addKeyListener(new KeyInput(world));

        new Window(WIDTH, HEIGHT, TITLE, this);
        hud = new HUD();

        GameObject rocket1 = new Rocket(0, HEIGHT - 50, ID.Rocket, world);
        GameObject sun = new Sun(WIDTH / 2, HEIGHT / 2, ID.Sun, world);
        GameObject planet = new Planet(WIDTH / 2 - 400, HEIGHT / 2, ID.Planet, world);
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

        this.requestFocus();
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
        world.tick();
        hud.tick();
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

        world.render(g);

        hud.render(g);

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
