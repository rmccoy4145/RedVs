/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.controllers;
import com.mccoy.redvs.screens.StartMenu;
import com.mccoy.redvs.assets.GameObject;
import java.awt.event.KeyEvent;

/**
 *
 * @author rmccoy
 */
public class StartMenuController {
     
     public void navigation(int key, GameObject obj) {
        if (obj instanceof StartMenu) {
            StartMenu startMenu = (StartMenu)obj;
            if (key == KeyEvent.VK_UP) {
               startMenu.startGame();
            }
            if (key == KeyEvent.VK_DOWN) {
                startMenu.exitGame();
            }

        }
    }
    
        public void menuActions(int key, GameObject obj) {
        if (obj instanceof StartMenu) {
            StartMenu starMenu = (StartMenu)obj;
            if (key == KeyEvent.VK_SPACE) {
                starMenu.select();
            }
        }
    }
    
}

