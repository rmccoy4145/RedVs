/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.scenes;

import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.assets.ID;
import com.mccoy.redvs.main.Handler;
import com.mccoy.redvs.main.StoryBoard;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class Winner extends GameObject  implements Scene {

    public Winner() {
        super(290, 200, ID.WINNER);
    }

    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
                   g.setColor(Color.GREEN);
            g.drawString("WINNER", x, y);
    }

    @Override
    public void start() {
//        if(!StoryBoard.isRunning()) {
//                        Handler handler = Handler.getInstance();
//            handler.addObject(this);
//            StoryBoard.startScene();
//        }
    }

    @Override
    public void check() {
        //need to implement
    }
   
    
    
}
