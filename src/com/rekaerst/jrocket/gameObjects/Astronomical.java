package com.rekaerst.jrocket.gameObjects;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import com.rekaerst.jrocket.Handler;
import com.rekaerst.jrocket.World;

public class Astronomical extends GameObject {

    public Astronomical(int x, int y, ID id, World handler) {
        super(x, y, id, handler);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public Ellipse2D getBounds() {
        return null;
    }

}
