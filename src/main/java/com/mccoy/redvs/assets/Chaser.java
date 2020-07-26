/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.assets;

import com.mccoy.redvs.assets.Player;
import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.assetmovement.ChaserMovement;
import com.mccoy.redvs.main.Handler;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class Chaser extends GameObject implements Enemy, Alive, Collidable{

    Player player;
    Handler handler;
    int wait = 0;
    int health = 50;
    
    public Chaser(int x, int y, Player player) {
        super(x, y, ID.ENEMY);
        height = 15; 
        width = 15;
        setWindowMaxPositions();
        this.player = player;
        setMovementBehavior(new ChaserMovement(this));
        movement.setSpeed(0);
        collisionCoolDown = 50;
    }

    @Override
    public void tick() {
        if (movement instanceof ChaserMovement) {
            ChaserMovement cm = (ChaserMovement) movement;
            cm.followPlayer(player);
            performAttack();
            cm.updatePosition();
            if(collisionCoolDown < 50) collisionCoolDown++;
            death();
         
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
    
    public void takeDMG() {
        health += -10;
        System.out.println("Chaser health: " + health);
    }

    public void death() {
        if (health <= 0) {
            //SoundHandler.deathSound();
            visible = false;
        }
    }
        public void collisionDetected(ID hitboxType) {
        if (collisionCoolDown == 50) {
        switch(hitboxType) {
            case PLAYER_ATACK:  collision = true;
            takeDMG();
            collisionCoolDown = 0;
                break;
                default:
                    break;

            }
        }
    }
    
    
}
