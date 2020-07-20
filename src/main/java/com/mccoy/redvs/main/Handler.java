/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author rmccoy
 */
public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();
    
    private static Handler instance;
    
    private Handler() {

    }

    public static Handler getInstance() {
        if (instance == null) {
            instance = new Handler();
        }
        return instance;
    }
    
    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            
        }
    }
    
    public void render(Graphics g){
         for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
            
        }       
    }
    
    public void cleanUp() {
        for (Iterator<GameObject> iterator = objects.iterator(); iterator.hasNext();) {
            GameObject next = iterator.next();
            if (!next.visible) {
                iterator.remove();
                System.out.println("removed:" + next.id.toString());
                System.out.println("Container Size:" + objects.size());
            }

        }
    }
    
    public void addObject(GameObject obj) {
        objects.add(obj);
    }
    
    public void removeObject(GameObject obj) {
        objects.remove(obj);
    }
    
}
