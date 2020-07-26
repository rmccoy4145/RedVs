/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.assets;

import com.mccoy.redvs.assets.Player;
import com.mccoy.redvs.assets.GameObject;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class HUD extends GameObject {
Player player;

    public HUD(Player player) {
        super(20, 400, ID.HUD);
        this.player = player;
    }

    @Override
    public void tick() {
 
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, player.health, 5);
        g.setColor(Color.blue);
        g.fillRect(x, y + 20, player.basicAttackCoolDown, 5);

    }
    
}
