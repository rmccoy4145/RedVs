/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.assets;

import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.utilities.EffectsUtility;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class ShockWave extends GameObject{
    
EffectsUtility effects;
    
    public ShockWave(int x, int y) {
        super(x, y, ID.PLAYER_ATACK);
        height = 125;
        width = 125;
        effects = new EffectsUtility(this, Color.MAGENTA);
        effects.setupShockwave(300);
    }

    
    @Override
    public void tick() {
        effects.shockwaveTick();
    }

    @Override
    public void render(Graphics g) {
        effects.shockwaveRender(g);
    }
    
}
