/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mccoy.redvs.misctest;

import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.utilities.GameUtilites;
import com.mccoy.redvs.main.Handler;
import com.mccoy.redvs.assets.ID;
import com.mccoy.redvs.controllers.KeyInput;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * 
 * @author rmccoy
 */
public class TestCanvas extends Canvas implements Runnable {
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;


        private Thread thread;
    private boolean running = false;
    private Handler handler;
 
    
    public TestCanvas() {
         handler = Handler.getInstance();
        this.addKeyListener(new KeyInput(handler));

        new TestWindow(WIDTH, HEIGHT, "TestCanvas", this);
        
        handler.addObject(new TestGO());
    }

    public synchronized void start() {
 
        thread = new Thread(this);
        thread.start();
        running = true;
        System.out.println("Starting testcanvas on " + thread.getName());
    }
    
    public synchronized void stop() {

        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        //GAME 
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS" + frames);
                frames = 0;
            }
            
        }
        stop();
    }
    
    private void tick() { 
        handler.tick();
        handler.cleanUp();
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
    }

    public static int positionClamp(int position, int min, int max) {
        if(position >= max) 
            return max;
        if(position <= min)
            return min;
        else
            return position;
    }
    
    public static void main(String[] args) {
        new TestCanvas();
    }
    
    private class TestGO extends GameObject{

    int c1X = 200;
    int c1Y = 200;
    int c2X = 300;
    int c2Y = 200;
    int radius;
    int radiusSq ;
    int moveItBy = 1;
    int rotation = 0;
    int wait = 0;
    
    public TestGO() {
        super(0, 0, ID.ENEMY);
        height = 50;
        width = height;
        radius = width/2;
        radiusSq = (int) Math.pow((radius + radius), 2);
 
    }

    @Override
    public void tick() {
               int distanceBetween = (int) (Math.pow(((c1X + radius) - (c2X + radius)), 2) + Math.pow(((c1Y + radius) - (c2Y + radius)), 2));
               
               boolean touching = false;
               if(distanceBetween == radiusSq || distanceBetween < radiusSq) touching = true;
               if(touching) System.out.println("Touching");
               else
                   System.out.println("NOT Touching");
        
        c2X = c2X + moveItBy;
        if(c2X == WIDTH) moveItBy = -1;
        if(c2X == 0) moveItBy = 1;
 

 
    }

    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.red);
       g.fillOval(c1X, c1Y, height, width);
       g.fillOval(c2X, c2Y, height, width);
    }
    
//    centerPosX = 200
//    centerPosY = 200
//
//    dx = mouseX - centerPosX
//    dy = mouseY - centerPosY
//    angle = math.atan(dx,dy)
//
//    dotPosX = centerPosX + math.cos(time/20) * 50
//    dotPosY = centerPosY + math.sin(time/20) * 50
//
//    love.graphics.points(centerPosX,centerPosY)
//    love.graphics.points(dotPosX,dotPosY)
//    love.graphics.print(math.cos(time/20),300,300)
    
}
    
}
