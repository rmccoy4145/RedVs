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
public class Projectile extends GameObject{

    Player player;
    
    public Projectile(int x, int y, Player player) {
        super(x, y, ID.PROJECTILE);
        this.height = 30;
        this.width = 30;
        setWindowMaxPositions();
        this.player = player;
        setMovementBehavior(new ChaserMovement(this));
        movement.setSpeed(3);
        trackPlayer();
    }

    @Override
    public void tick() {
        movement.updatePosition();
        ifOffScreen();
        explode();

    }

    @Override
    public void render(Graphics g) {
        if (visible) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, height, width);
        } 

    }
    
    public void trackPlayer() {
                ChaserMovement cm = (ChaserMovement) movement;
            cm.followPlayer(player);
    }
    
    private void explode() {
        if(!visible) {
            Handler handler = Handler.getInstance();
            handler.addObject(new Explosion(x, y));
        }
    }
    
}
