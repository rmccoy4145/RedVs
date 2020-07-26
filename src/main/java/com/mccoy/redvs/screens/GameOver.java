/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.screens;

import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.assets.ID;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class GameOver extends GameObject{

    public GameOver() {
        super(290, 200, ID.GAMEOVER);
    }

    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
                   g.setColor(Color.RED);
            g.drawString("GAMEOVER", x, y);
    }
    
}
