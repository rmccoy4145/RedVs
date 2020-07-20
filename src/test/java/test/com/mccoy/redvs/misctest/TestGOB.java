/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mccoy.redvs.misctest;

import com.mccoy.redvs.main.GameObject;
import com.mccoy.redvs.main.GameUtilites;
import com.mccoy.redvs.main.ID;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rmccoy
 */
public class TestGOB extends GameObject{

    int[] pointToCircle = {300, 300};
    int rotation = 1;
    int wait = 0;
    public TestGOB() {
        super(0, 0, ID.Enemy);
        x = pointToCircle[0];
        y = pointToCircle[1];
        height = 20;
        width = 20;
    }

    
    
    @Override
    public void tick() {
        if (wait >= 200) {
            if (rotation % 1 == 0) {
                x = GameUtilites.newXFromAngle(pointToCircle[0], rotation, 100);
                y = GameUtilites.newYFromAngle(pointToCircle[1], rotation, 100);
            }
                rotation++;
  
            wait = 0;
        }

        wait++;

        System.out.println("rotation: " + rotation);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
       g.fillRect(x, y, width, height);
    }
    
}
