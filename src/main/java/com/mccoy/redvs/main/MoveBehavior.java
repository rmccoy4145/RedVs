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
public interface MoveBehavior{
   
    public void setVelX(int velX);

    public void setVelY(int velY);

    public void setSpeed(int speed);
    
    public int getSpeed();
    
    public int getVelX();
    public int getVelY();

    public void moveUp();

    public void moveDown();

    public void moveLeft();

    public void moveRight();
    
    public void stopMoveY();

    public void stopMoveX();
    
    public void updatePosition();
    
    public boolean isMoving();

}
