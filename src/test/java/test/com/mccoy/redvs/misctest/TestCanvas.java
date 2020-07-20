/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mccoy.redvs.misctest;

import com.mccoy.redvs.main.GameObject;
import com.mccoy.redvs.main.GameUtilites;
import com.mccoy.redvs.main.Handler;
import com.mccoy.redvs.main.ID;
import com.mccoy.redvs.main.KeyInput;
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

    int centerPosX = 200;
    int centerPosY = 200;
    int rotation = 0;
    int wait = 0;
    
    public TestGO() {
        super(0, 0, ID.Enemy);
        x = centerPosX;
        y = centerPosY;
        height = 20;
        width = 20;
    }

    @Override
    public void tick() {

        x = (int) GameUtilites.newXFromAngle(centerPosX, rotation, 50);
        y = (int) GameUtilites.newYFromAngle(centerPosY, rotation, 50);
        rotation++;
        if (rotation == 360) {
            rotation = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.red);
       g.fillRect(x, y, width, height);
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
