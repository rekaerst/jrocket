package com.rekaerst.jrocket.gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.rekaerst.jrocket.World;

public class Part extends GameObject {

    public Part(int x, int y, ID id, World world) {
        super(x, y, id, world);
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}
