/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mccoy.redvs.screen;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rmccoy
 */
public class ScreenCompisite {
    public static void main(String[] args) {
        ArrayList<Screen> composite = new ArrayList<>();
        
        Menu start = new Menu("Start", "Main start screen");
        start.addChild(new Menu("Start Game", "Execute Game"));
        start.addChild(new Menu("Options", "Game Settings"));
        start.addChild(new Menu("Exit", "Close App"));
        
        Menu dev = new Menu("Dev", "Developer Mode");
        
        composite.add(start);
        composite.add(dev);
        
        for (Iterator<Screen> iterator = composite.iterator(); iterator.hasNext();) {
            Screen next = iterator.next();
            next.paint();
        }
        
    }
}
