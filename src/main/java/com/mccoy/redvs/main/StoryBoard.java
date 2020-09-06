/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import com.mccoy.redvs.scenes.StartMenu;
import com.mccoy.redvs.scenes.SplashScreen;
import com.mccoy.redvs.assets.Chaser;
import com.mccoy.redvs.assets.HUD;
import com.mccoy.redvs.assets.Player;
import com.mccoy.redvs.scenes.Scene;
import com.mccoy.redvs.scenes.Stage1;
import com.mccoy.redvs.scenes.States;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rmccoy
 */
public class StoryBoard {
  
  private static States state = States.SPLASH_SCREEN;
  private static boolean sceneRunning = false;
  
  public Map<States, Scene> scenes = new HashMap<>();

    public StoryBoard() {
        scenes.put(States.SPLASH_SCREEN, new SplashScreen());
        scenes.put(States.START_MENU, new StartMenu());
        scenes.put(States.STAGE_1, new Stage1());
    }
  
 
    public void start() {

        Scene currentScene = scenes.get(StoryBoard.state);
        if(!isRunning()) {
        currentScene.start();
        }
        currentScene.check();
        System.out.println(String.format("Current Game State: %s", StoryBoard.state.toString()));
        
    }
    
    public static void startScene() {
        sceneRunning = true;
    }
    
    public static void stopScene() {
        sceneRunning = false;
    }
    
    public static boolean isRunning() {
        return sceneRunning;
    }
    
    public static void setState(States state) {
       StoryBoard.state = state;
    }
   
}
