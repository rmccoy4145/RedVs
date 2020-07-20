/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

/**
 *
 * @author rmccoy
 */
public class BasicGOMovement implements MoveBehavior {

    protected int velX, velY;
    protected int speed;

    protected GameObject gameObject;

    public BasicGOMovement(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void setVelX(int velX) {
        this.velX = velX;
    }

    @Override
    public void setVelY(int velY) {
        this.velY = velY;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getVelX() {
        return velX;
    }

    @Override
    public int getVelY() {
        return velY;
    }

    @Override
    public void moveUp() {
        velY = -speed;
    }

    @Override
    public void moveDown() {
        velY = speed;
    }

    @Override
    public void moveLeft() {
        velX = -speed;
    }

    @Override
    public void moveRight() {
        velX = speed;
    }

    @Override
    public void stopMoveY() {
        this.setVelY(0);
    }

    @Override
    public void stopMoveX() {
        this.setVelX(0);
    }

    @Override
    public boolean isMoving() {
        if (velX != 0 && velY != 0) {
            return true;
        } else {
            return false;
        }
    }
    
    

    @Override
    public void updatePosition() {
        int x = gameObject.getX();
        int y = gameObject.getY();
        int width = gameObject.getWidth();
        int height = gameObject.getHeight();
        x += velX;
        y += velY;

        gameObject.setX(Game.positionClamp(x, 0, gameObject.windowMaxXPosition));
        gameObject.setY(Game.positionClamp(y, 0, gameObject.windowMaxYPosition));
    }
}
