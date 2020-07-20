/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author rmccoy
 */
public class EffectsUtility {
    protected int intensity;
    protected int wait;
    protected int distance;
    protected float alpha;
    protected int expandBy;
    protected int rotation = 0;
    protected Color effectColor;
    protected Random rn = new Random();
    protected LinkedList<Double> particaleCosX = new LinkedList<>();
    protected LinkedList<Double> particaleSinY = new LinkedList<>();
    private GameObject gameObject;
    protected int x;
    protected int y;

    public EffectsUtility(GameObject go, Color color) {
        this.gameObject = go;
        this.effectColor = color;
        x = gameObject.getX();
        y = gameObject.getY();
    }
    
    public void setupExplode() {
    intensity = 8;
    wait = 5;
    distance = 10;
    alpha = intensity * 0.1f;
    expandBy = 0;
    generateExplodeParticlePoints();
    }
    
    
    public void explodeTick() {
        wait--;
        distance = distance + 4;
        expandBy = expandBy + 3;
        if (wait <= 0) {
            intensity--;
            alpha = intensity * 0.1f;
            wait = 5;
        }
        if (intensity <= 0) {
            gameObject.visible = false;
        }
    }

    public void explodeRender(Graphics g) {
        if (gameObject.visible) {
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setPaint(effectColor);

            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            int keepCenter = expandBy/2;
            g2d.fillOval(x - keepCenter, y - keepCenter, gameObject.getHeight() + expandBy, gameObject.getWidth() + expandBy);
            int rand = rn.nextInt(20 - 5 + 1) + 5;
            for (int i = 1; i < particaleCosX.size(); i++) {
                int newX = (int) (x + particaleCosX.get(i) * distance + rand);
                int newY = (int) (y + particaleSinY.get(i) * distance + rand);
                g2d.fillOval(newX, newY, 15, 15);
            }

        }
    }
    
       private void generateExplodeParticlePoints() {
        for (int i = 0; i < 20; i++) {
           double cosX = GameUtilites.newXAngle(i);
            double sinY = GameUtilites.newYAngle(i);
            particaleCosX.add(cosX);
            particaleSinY.add(sinY);
        }
    }
    
        public void setupMuzzleFlash() {
    intensity = 8;
    wait = 5;
    distance = 10;
    alpha = intensity * 0.1f;
    expandBy = 0;
    generateMuzzleFlashParticlePoints();
    }

    private void generateMuzzleFlashParticlePoints() {
        for (int i = 0; i < 20; i++) {
            double cosX = GameUtilites.newXAngle(i);
            double sinY = GameUtilites.newYAngle(i);
            particaleCosX.add(cosX);
            particaleSinY.add(sinY);
        }
    }
    
    public void muzzleFlashTick(){
                wait--;
        distance = distance + 1;
        if (wait <= 0) {
            intensity--;
            alpha = intensity * 0.1f;
            wait = 5;
        }
        if (intensity <= 0) {
            gameObject.visible = false;
        }
    }
    
    public void muzzleFlashRender(Graphics g) {
        if (gameObject.visible) {
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setPaint(effectColor);

            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            //g2d.fillOval(x, y, 15, 15);
            int rand = rn.nextInt(15 - 5 + 1) + 5;
            for (int i = 1; i < particaleCosX.size(); i++) {
                int newX = GameUtilites.newRadialPointFromAngle(x, particaleCosX.get(i), distance) + rand;
                int newY = GameUtilites.newRadialPointFromAngle(y, particaleSinY.get(i), distance) + rand;
                g2d.fillOval(newX, newY, gameObject.getHeight(), gameObject.getWidth());
            }

        }
    }
    
    public void rotateAroundPosition(int centerPosX, int centerPosY, int diameter) {
        x = (int) GameUtilites.newXFromAngle(centerPosX, rotation, diameter);
        y = (int) GameUtilites.newYFromAngle(centerPosY, rotation, diameter);
        rotation++;
        if (rotation == 360) {
            rotation = 0;
        }
    }
    
    public void setupShockwave() {
        intensity = 8;
        wait = 50;
        alpha = intensity * 0.1f;
        expandBy = 0;
        generateExplodeParticlePoints();
    }

    public void shockwaveTick() {
        wait--;
        if (wait >= 30) {
            expandBy = expandBy - 5;
            intensity = 1;
        }
        if (wait < 20) {
            expandBy = expandBy + 10;
            intensity = 9;
        }
        if (wait > 0) {
            alpha = intensity * 0.1f;
        }
        if (wait <= 0) {
            gameObject.visible = false;
        }
    }

    public void shockwaveRender(Graphics g) {
        if (gameObject.visible) {
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setPaint(effectColor);

            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            int keepCenter = expandBy / 2;
            g2d.fillOval(x - keepCenter, y - keepCenter, gameObject.getHeight() + expandBy, gameObject.getWidth() + expandBy);

        }
    }
    
    }

