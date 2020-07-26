/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import com.mccoy.redvs.controllers.KeyInput;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author rmccoy
 */
public class Game extends Canvas implements Runnable {
    
    public static final long serialVersionID = -274921492884053948L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    private Handler handler;
 
    public Game() {

        handler = Handler.getInstance();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Game", this);
        
    }

    public synchronized void start() {
 
        thread = new Thread(this);
        thread.start();
        running = true;
        System.out.println("Starting game on " + thread.getName());
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
        StoryBoard.start();
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
        new Game();
    }
    
}
