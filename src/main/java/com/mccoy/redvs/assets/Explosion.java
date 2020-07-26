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
public class Explosion extends GameObject{
    protected EffectsUtility effects;
    protected Color explosionColor = Color.ORANGE;
    
    public Explosion(int x, int y) {
        super(x, y, ID.PARTICLES);
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
