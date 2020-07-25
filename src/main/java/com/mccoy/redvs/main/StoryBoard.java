/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

/**
 *
 * @author rmccoy
 */
public class StoryBoard {
 private static boolean splashScreen = false;
 private static boolean splashScreenComplete = false;
 private static boolean stage1 = false;
  private static boolean executeStartMenu = false;
  private static boolean stageReady = false;
  
  
 
    public static void start() {
        splash();
        startMenu();
        stage1();
    }
    
    public static void splash() {
        if (splashScreen == false) {
        splashScreen = true;
        Handler handler = Handler.getInstance();
        SplashScreen ss = new SplashScreen();
            handler.addObject(ss);
        }
        if (!splashScreenComplete) {
            Handler handler = Handler.getInstance();
            if (handler.objects.size() == 0) {
                splashScreenComplete = true;
            }
        }
    }
    
    
    public static void startMenu() {
        if (splashScreenComplete && !executeStartMenu) {
        Handler handler = Handler.getInstance();
        StartMenu startMenu = new StartMenu();
        handler.addObject(startMenu);
        executeStartMenu = true;
        }
                if (executeStartMenu ) {
            Handler handler = Handler.getInstance();
            if (handler.objects.size() == 0) {
                stageReady = true;
                handler.startMenu = false;
            }
        }
    }

    public static void stage1() {
        if (stageReady && !stage1) {
            Handler handler = Handler.getInstance();
            handler.playing = true;
            stage1 = true;
            Player player = new Player(100, 100);
            handler.addObject(player);
            handler.addObject(new Chaser(300, 300, player));
            handler.addObject(new HUD( player));
        }
    }
    
}
