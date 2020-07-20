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
public class Explosion extends GameObject{
    protected EffectsUtility effects;
    protected Color explosionColor = Color.ORANGE;
    
    public Explosion(int x, int y) {
        super(x, y, ID.Particles);
        height = 40;
        width = 40;
        effects = new EffectsUtility(this, explosionColor);
        effects.setupExplode();
    }

    @Override
    public void tick() {
        effects.explodeTick();
    }

    @Override
    public void render(Graphics g) {
        effects.explodeRender(g);

    }
    

}
