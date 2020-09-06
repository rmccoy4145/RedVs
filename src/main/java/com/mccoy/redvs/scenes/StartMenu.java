/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.scenes;

import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.main.Game;
import com.mccoy.redvs.assets.ID;
import com.mccoy.redvs.main.Handler;
import com.mccoy.redvs.main.StoryBoard;
import com.mccoy.redvs.resources.Resources;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author rmccoy
 */
public class StartMenu extends GameObject  implements Scene {
boolean startGameOption;
boolean exitGameOption;
boolean proceed = false;
boolean shutDown = false;
private Resources resources;
Image titleScreen;
int wait = 20;

    public StartMenu() {
        super(0, 0, ID.MENU);
    }

    public void startGame() {
        startGameOption = true;
        exitGameOption = false;
                height = Game.HEIGHT;
        width = Game.WIDTH;
        resources = Resources.getInstance();
        titleScreen = resources.titleImage;
    }
    
    public void exitGame() {
        startGameOption = false;
        exitGameOption = true;
    }
    
    public void select() {
        if(startGameOption) proceed();
        if(exitGameOption) shutdown();
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
        if (proceed) {
            visible = false;
        }
        if(shutDown) System.exit(0);
//        if(proceed) wait--;
//        if(wait <= 0) visible = false;
        
    }

    @Override
    public void render(Graphics g) {
        g.clearRect(x, y, width, height);
        g.drawImage(titleScreen, x, y, null);

        if (startGameOption) {
            g.drawImage(titleScreen, x, y, null);
            g.setColor(Color.GREEN);
            g.drawString("Start Game", 290, 345);
        }
        if (exitGameOption) {
            g.drawImage(titleScreen, x, y, null);
            g.setColor(Color.RED);
            g.drawString("Exit Game", 290, 345);
        }

    }

    @Override
    public void start() {
        if(!StoryBoard.isRunning()) {
                Handler handler = Handler.getInstance();
            handler.addObject(this);
            StoryBoard.startScene();
        }
    }

    @Override
    public void check() {
        if (!visible) {
            StoryBoard.stopScene();
            StoryBoard.setState(State.STAGE_1);
        }
    }
    
    
}
