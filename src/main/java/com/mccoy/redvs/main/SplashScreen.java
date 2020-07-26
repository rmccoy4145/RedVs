/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


/**
 *
 * @author rmccoy
 */
public class SplashScreen extends GameObject{
private Resources resources;
Image titleScreen;
    protected int wait = 250;
    
    public SplashScreen() {
        super(0, 0, ID.SPLASH);
        height = Game.HEIGHT;
        width = Game.WIDTH;
        resources = Resources.getInstance();
        titleScreen = resources.titleImage;
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

        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        g.drawImage(titleScreen, 0, 0, null);

    }
    
    
    
}
