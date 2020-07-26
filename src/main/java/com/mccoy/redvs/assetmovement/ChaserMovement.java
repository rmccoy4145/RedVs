/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.assetmovement;

import com.mccoy.redvs.assetmovement.BasicGOMovement;
import com.mccoy.redvs.assets.Player;
import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.utilities.GameUtilites;

/**
 *
 * @author rmccoy
 */
public class ChaserMovement extends BasicGOMovement{
    protected double lastDegree = -999;
    public ChaserMovement(GameObject gameObject) {
        super(gameObject);
    }
    
    public void followPlayer(Player player) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        int playerX = player.getX();
        int playerY = player.getY();
        if (lastDegree == -999) {
            lastDegree = GameUtilites.angleToTwoPoints(playerX, playerY, x, y);
        }
 
        if (!player.movement.isMoving()) {
            lastDegree = GameUtilites.angleToTwoPoints(playerX, playerY, x, y);

        }

        setVelX(GameUtilites.newVelictyXFromAngle(lastDegree, 3));
        setVelY(GameUtilites.newVelictyYFromAngle(lastDegree, 3));


 

    }

    
}
