package com.rekaerst;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Rocket {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        // TODO Auto-generated constructor stub
        setVelX(1);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.white);
        g.fillRect(x, y, 40, 40);
    }

    @Override
    public void tick() {
        super.tick();
        x += velX;
        y += velY;
    }

}
