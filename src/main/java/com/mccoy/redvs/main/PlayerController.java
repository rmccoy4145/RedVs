/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;
import java.awt.event.KeyEvent;

/**
 *
 * @author rmccoy
 */
public class PlayerController {
    public void movePlayer(int key, GameObject obj) {
        if (obj instanceof Player) {
            Player player = (Player)obj;
            MoveBehavior mb = player.getMovementBehavior();
            if (key == KeyEvent.VK_UP) {
               mb.moveUp();
            }
            if (key == KeyEvent.VK_DOWN) {
                mb.moveDown();
            }
            if (key == KeyEvent.VK_LEFT) {
                mb.moveLeft();
            }
            if (key == KeyEvent.VK_RIGHT) {
                mb.moveRight();
            }
        }
    }
    
        public void playerActions(int key, GameObject obj) {
        if (obj instanceof Player) {
            Player player = (Player)obj;
            if (key == KeyEvent.VK_A) {
                player.setExecuteBasicAttack();
            }
        }
    }
    
    
    public void stopPlayer(int key, GameObject obj) {
        if (obj instanceof Player) {
            Player player = (Player)obj;
            MoveBehavior mb = player.getMovementBehavior();
            if (key == KeyEvent.VK_UP) {
                mb.stopMoveY();
            }
            if (key == KeyEvent.VK_DOWN) {
                mb.stopMoveY();
            }
            if (key == KeyEvent.VK_LEFT) {
                mb.stopMoveX();
            }
            if (key == KeyEvent.VK_RIGHT) {
                mb.stopMoveX();
            }
        }
    }
}
