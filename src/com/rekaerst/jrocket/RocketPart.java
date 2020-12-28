package com.rekaerst.jrocket;

import java.awt.Graphics;

public class RocketPart extends GameObject {

    public RocketPart(int x, int y, ID id) {
        super(x, y, id);
        // TODO Auto-generated constructor stub
    }

    public void render(Graphics g) {
        g.setColor(getColor());
    }

    public void tick() {
        x += velX;
        y += velY;
    }

}
