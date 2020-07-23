/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class Player extends GameObject{
    
    int health = 100;
    int basicAttackCoolDown = 200;
    boolean executeBasicAttack = false;
    int collisionCoolDown = 100;
    boolean collision = false;
    
    public Player(int x, int y) {
        super(x, y, ID.PLAYER);
        height = 32;
        width = 32;
        setWindowMaxPositions();
        setMovementBehavior(new BasicGOMovement(this));
        movement.setSpeed(5);
    }

    @Override
    public void tick() {
        if(basicAttackCoolDown < 200) basicAttackCoolDown++;
        if(executeBasicAttack) basicAttack();
        if(collisionCoolDown < 100) collisionCoolDown++;
        movement.updatePosition();
        death();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, height, width);
    }

    public void setExecuteBasicAttack() {
        if(basicAttackCoolDown == 200) {
        this.executeBasicAttack = true;
        }
    }

    public void basicAttack(){
        Handler handler = Handler.getInstance();
        handler.addObject(new ShockWave(x, y));
        basicAttackCoolDown = 0;
        executeBasicAttack = false;
    }
    
    public void collisionDetected(ID hitboxType) {
        if (collisionCoolDown == 100) {
        switch(hitboxType) {
            case ENEMY:  collision = true;
            takeDMG();
            collisionCoolDown = 0;
                break;
            case PROJECTILE:  collision = true;
            takeDMG();
            collisionCoolDown = 0;
                    break;
                default:
                    break;

            }
        }
    }

    private void takeDMG() {
        SoundHandler.dmgSound();
        health -= 10;
    }
    
    private void death() {
        if (health <= 0) SoundHandler.deathSound();
    }

}
