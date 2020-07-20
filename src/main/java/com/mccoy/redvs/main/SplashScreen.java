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
public class SplashScreen extends GameObject{

    protected int wait = 250;
    
    public SplashScreen() {
        super(0, 0, ID.Splash);
        height = Game.HEIGHT;
        width = Game.WIDTH;
    }

    
    
    @Override
    public void tick() {
        wait--;
        if (wait <= 0) {
            visible = false;
        }
    }


    @Override
    public void render(Graphics g) {
        if (!visible) {
            g.clearRect(x, y, width, height);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
            g.setColor(Color.RED);
            g.drawString("RED vs", 300, 200);
        }

    }
    
    
    
}
