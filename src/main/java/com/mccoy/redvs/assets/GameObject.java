/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.assets;

import com.mccoy.redvs.main.Game;
import com.mccoy.redvs.assetmovement.MoveBehavior;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public abstract class GameObject {
    
    protected int x, y, height, width;
    public ID id;
    public MoveBehavior movement;
    public boolean visible = true;
    protected int windowMaxXPosition;
    protected int windowMaxYPosition;
    protected HitBox hitbox;
    int collisionCoolDown = 100;
    boolean collision = false;

    public abstract void tick();
    public abstract void render(Graphics g);
    
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        hitbox = new HitBox(this);
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

    public int getWindowMaxXPosition() {
        return windowMaxXPosition;
    }

    public int getWindowMaxYPosition() {
        return windowMaxYPosition;
    }

    
    public void ifOffScreen() {
                if (x == windowMaxXPosition || y == windowMaxYPosition || x == 0 || y == 0) {
            visible = false;
        }
    }

    public HitBox getHitbox() {
        return hitbox;
    }
    
}
