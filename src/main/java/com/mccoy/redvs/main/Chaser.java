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
public class Chaser extends GameObject implements Enemy{

    Player player;
    Handler handler;
    int wait = 0;
    
    public Chaser(int x, int y, Player player) {
        super(x, y, ID.ENEMY);  
        height = 15; 
        width = 15;
        setWindowMaxPositions();
        this.player = player;
        setMovementBehavior(new ChaserMovement(this));
        movement.setSpeed(0);
    }

    @Override
    public void tick() {
        if (movement instanceof ChaserMovement) {
            ChaserMovement cm = (ChaserMovement) movement;
            cm.followPlayer(player);
            performAttack();
            cm.updatePosition();
         
        }
    }


    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, height, width);
    }

    @Override
    public void performAttack() {
        this.wait++;
        if (wait == 300) {
            Handler handler = Handler.getInstance();
            handler.addObject(new MuzzleFlash(x, y));
            handler.addObject(new Projectile(x, y, player));
            wait = 0;
        }
    }
    
    
}
