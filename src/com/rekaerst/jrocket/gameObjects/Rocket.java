package com.rekaerst.jrocket.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.rekaerst.jrocket.World;

public class Rocket extends Part {

    public Rocket(int x, int y, ID id, World world) {
        super(x, y, id, world);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

}
