/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.Rectangle;

/**
 *
 * @author rmccoy
 */
public class HitBox {
    
    GameObject gameObject;
    Rectangle boxRect;
    int hitBoxX;
    int hitBoxY;
    int hitBoxWidth;
    int hitBoxHeight;
    int hitBoxRadius;
    int hitBoxArea;
    ID hitBoxType;
    
    public HitBox(GameObject gameObject) {
        this.gameObject = gameObject;
        hitBoxType = gameObject.id;
        hitBoxRadius = gameObject.getWidth() / 2; //NEED TO ADD HEIGHT CHECKS
        hitBoxArea = (int) Math.pow(hitBoxRadius + hitBoxRadius, 2);
    }
    
    
    public void setHitBox() {
        hitBoxX = gameObject.x;
        hitBoxY = gameObject.y;
        hitBoxWidth = gameObject.getWidth();
        hitBoxHeight = gameObject.getHeight();
        boxRect = new Rectangle(hitBoxX, hitBoxY, hitBoxWidth, hitBoxHeight);
    }
    
    public void rectIsCollision(HitBox hitBoxToCheck) {  
        setHitBox();
        hitBoxToCheck.setHitBox();
        if(boxRect.intersects(hitBoxToCheck.getBoxRect())) {
            if(gameObject instanceof Player) {
                Player player = (Player) gameObject;
                player.collisionDetected(hitBoxToCheck.getHitBoxType());
            }
        }     
    }
    
    public void isAdvancedCollision(HitBox hitBoxToCheck) {  
        setHitBox();
        hitBoxToCheck.setHitBox();
        int distanceBetween = (int) (Math.pow(((hitBoxX + hitBoxRadius) - (hitBoxToCheck.getHitBoxX() + hitBoxToCheck.getHitBoxRadius())), 2) + Math.pow(((hitBoxY + hitBoxRadius) - (hitBoxToCheck.getHitBoxY() + hitBoxToCheck.getHitBoxRadius())), 2));
        int radiusSumSq = (int) (Math.pow(hitBoxRadius + hitBoxToCheck.getHitBoxRadius(), 2));
        if(distanceBetween == radiusSumSq || distanceBetween < radiusSumSq) {

        }

    }

    public int getHitBoxX() {
        return hitBoxX;
    }

    public int getHitBoxY() {
        return hitBoxY;
    }

    public int getHitBoxRadius() {
        return hitBoxRadius;
    }

    public Rectangle getBoxRect() {
        return boxRect;
    }

    public ID getHitBoxType() {
        return hitBoxType;
    }
    
    
    
    
    
    
}
