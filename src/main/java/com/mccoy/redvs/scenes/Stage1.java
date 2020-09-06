/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.scenes;

import com.mccoy.redvs.assets.Chaser;
import com.mccoy.redvs.assets.HUD;
import com.mccoy.redvs.assets.Player;
import com.mccoy.redvs.main.Handler;
import com.mccoy.redvs.main.StoryBoard;

/**
 *
 * @author rmccoy
 */
public class Stage1 implements Scene {

    public Stage1() {
    }

    @Override
    public void start() {
        if(!StoryBoard.isRunning()) {
            Handler handler = Handler.getInstance();
            handler.playing = true;
            Player player = new Player(100, 100);
            handler.addObject(player);
            handler.addObject(new Chaser(300, 300, player));
            handler.addObject(new Chaser(400, 400, player));
            handler.addObject(new Chaser(250, 350, player));
            handler.addObject(new Chaser(420, 400, player));
            handler.addObject(new Chaser(280, 280, player));
            handler.addObject(new HUD( player));
            StoryBoard.startScene();
        }
    }

    @Override
    public void check() {
        //need to implement
    }
 
    
    
}
