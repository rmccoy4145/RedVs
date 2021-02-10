/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import com.mccoy.redvs.assets.Collidable;
import com.mccoy.redvs.assets.GameObject;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author rmccoy
 */
public class Handler {
    public LinkedList<GameObject> objects = new LinkedList<>();
    public boolean playing = false;
    public boolean startMenu = true;
    
    private static Handler instance;
    
    private Handler() {

    }

    public synchronized static Handler getInstance() {
        if (instance == null) {
            instance = new Handler();
        }
        return instance;
    }
    
    public synchronized void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            detectCollisions(tempObject);
            
        }
    }
    
    public synchronized void render(Graphics g){
         for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
            
        }       
    }
    
    public synchronized void cleanUp() {
        for (Iterator<GameObject> iterator = objects.iterator(); iterator.hasNext();) {
            GameObject next = iterator.next();
            if (!next.visible) {

                //System.out.println("removing:" + next.id.toString());
                iterator.remove();
                //System.out.println("Container Size:" + objects.size());
            }

        }
    }
    
    public synchronized void addObject(GameObject obj) {
        objects.add(obj);
    }
    
    public synchronized void removeObject(GameObject obj) {
        objects.remove(obj);
    }
    
    private synchronized void detectCollisions(GameObject obj) {
        if (obj instanceof Collidable) {
            for (int i = 0; i < objects.size(); i++) {
                GameObject tempObject = objects.get(i);
                if (tempObject == obj) {
                    //Do nothing
                } else {
                    obj.getHitbox().rectIsCollision(tempObject.getHitbox());
                }
            }
        }
        
    }
    
}
