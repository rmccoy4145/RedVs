/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public abstract class GameObject {
    
    protected int x, y, height, width;
    protected ID id;
    protected MoveBehavior movement;
    protected boolean visible = true;
    protected int windowMaxXPosition;
    protected int windowMaxYPosition;

    public abstract void tick();
    public abstract void render(Graphics g);
    
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setMovementBehavior(MoveBehavior movement) {
        this.movement = movement;
    }

    public MoveBehavior getMovementBehavior() {
        return movement;
    }

    public void setWindowMaxPositions() {
        this.windowMaxXPosition = Game.WIDTH - (width);
        this.windowMaxYPosition = Game.HEIGHT - (height * 2 - ((int) (height * 0.15)));
    }

    public void ifOffScreen() {
                if (x == windowMaxXPosition || y == windowMaxYPosition || x == 0 || y == 0) {
            visible = false;
        }
    }
    
}
