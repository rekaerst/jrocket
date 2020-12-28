package com.rekaerst.jrocket.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import com.rekaerst.jrocket.World;

public class Sun extends Astronomical {

    public Sun(int x, int y, ID id, World world) {
        super(x, y, id, world);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.yellow);
        g.fillOval(x - 100, y - 100, 200, 200);
    }

    @Override
    public void tick() {
        super.tick();
    }

}
