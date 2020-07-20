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
public class ShockWave extends GameObject{
    
EffectsUtility effects;
    
    public ShockWave(int x, int y) {
        super(x, y, ID.Projectile);
        height = 200;
        width = 200;
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
