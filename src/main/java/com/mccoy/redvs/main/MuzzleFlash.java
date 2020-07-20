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
public class MuzzleFlash extends GameObject {

    protected EffectsUtility effects;
    protected Color flashColor = Color.YELLOW;

    public MuzzleFlash(int x, int y) {
        super(x, y, ID.Particles);
        height = 2;
        width = 2;
        effects = new EffectsUtility(this, flashColor);
        effects.setupMuzzleFlash();
    }

    @Override
    public void tick() {
        effects.muzzleFlashTick();
    }

    @Override
    public void render(Graphics g) {
        effects.muzzleFlashRender(g);

    }

}
