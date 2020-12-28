package com.rekaerst.jrocket;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, 200, 50);
        g.setColor(Color.green);
        g.fillRect(0, 50, 200, 50);
    }
}
