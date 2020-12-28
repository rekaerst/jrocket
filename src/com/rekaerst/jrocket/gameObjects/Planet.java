package com.rekaerst.jrocket.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import com.rekaerst.jrocket.World;

public class Planet extends Astronomical {
    public Planet(int x, int y, ID id, World world) {
        super(x, y, id, world);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.blue);
        g.fillOval(x - 25, y - 25, 50, 50);
    }

    @Override
    public void tick() {
    }

}
