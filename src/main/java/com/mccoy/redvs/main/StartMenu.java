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
public class StartMenu extends GameObject{
boolean startGame = true;
boolean exitGame = false;
boolean proceed = false;
boolean shutDown = false;
private Resources resources;
Image titleScreen;
int wait = 20;

    public StartMenu() {
        super(0, 0, null);
    }

    public void startGame() {
        startGame = true;
        exitGame = false;
                height = Game.HEIGHT;
        width = Game.WIDTH;
        resources = Resources.getInstance();
        titleScreen = resources.titleImage;
    }
    
    public void exitGame() {
        startGame = false;
        exitGame = true;
    }
    
    public void select() {
        if(startGame) proceed();
        if(exitGame) shutdown();
    }

    public void proceed() {
        proceed = true;
    }
    
    public void shutdown() {
        shutDown = true;
    }
    
    public boolean isProceed() {
        return proceed;
    }

    public boolean isShutDown() {
        return shutDown;
    }
    
    
    @Override
    public void tick() {
        if(proceed) wait--;
        if(wait <= 0) visible = false;
        
    }

    @Override
    public void render(Graphics g) {
        if(visible) {
                    g.setColor(Color.BLUE);
            g.fillRect(0, 0, width, height);
        g.drawImage(titleScreen, 0, 0, null);

        if (startGame) {

            g.setColor(Color.GREEN);
            g.drawString("Start Game", 120, 345);
        }
        if (exitGame) {
            g.drawImage(titleScreen, 0, 0, null);
            g.setColor(Color.RED);
            g.drawString("Exit Game", 120, 345);
        }
        }

    }
    
}
