/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mccoy.redvs.misctest;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import test.com.mccoy.redvs.misctest.TestCanvas;

/**
 *
 * @author rmccoy
 */
public class TestWindow extends Canvas{
    public static final long serialVersionID = -687991502884005033L;
    
    public TestWindow(int width, int height, String title, TestCanvas testCanvas) {
        JFrame frame = new JFrame();
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(testCanvas);
        frame.setVisible(true);
        testCanvas.start();
        
        
    }
    

}

