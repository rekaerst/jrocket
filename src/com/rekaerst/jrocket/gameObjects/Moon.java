package com.rekaerst.jrocket.gameObjects;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import com.rekaerst.jrocket.World;

public class Moon extends Astronomical {

    public Moon(int x, int y, ID id, World world) {
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
    public Ellipse2D getBounds() {
        return super.getBounds();
    }
}
