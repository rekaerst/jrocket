package com.rekaerst.jrocket.gameObjects;

import java.awt.Graphics;
import java.awt.Shape;

import com.rekaerst.jrocket.World;

public abstract class GameObject {

    protected int x, y;
    protected double mass;
    protected ID id;
    protected int velX, velY;
    protected World world;

    public GameObject(int x, int y, ID id, World world) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.world = world;
        world.addObject(this);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Shape getBounds();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
