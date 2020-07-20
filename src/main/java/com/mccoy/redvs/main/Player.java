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
    
    public Player(int x, int y) {
        super(x, y, ID.Player);
        height = 32;
        width = 32;
        setWindowMaxPositions();
        setMovementBehavior(new BasicGOMovement(this));
        movement.setSpeed(5);
    }

    @Override
    public void tick() {
        if(basicAttackCoolDown < 200) basicAttackCoolDown++;
        movement.updatePosition();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, height, width);
    }

    public void basicAttack(){
        if(basicAttackCoolDown == 200) {
        Handler handler = Handler.getInstance();
        handler.addObject(new ShockWave(x, y));
        basicAttackCoolDown = 0;
        }
    }

}
