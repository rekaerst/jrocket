package com.rekaerst;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends RocketPart {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        color = Color.white;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.fillRect(x, y, 40, 40);
    }

    @Override
    public void tick() {
        super.tick();

    }

}
