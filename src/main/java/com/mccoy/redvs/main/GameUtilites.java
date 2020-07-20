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
public class GameUtilites {

    public static double angleToTwoPoints(double point1X, double point1Y,
            double point2X, double point2Y) {

        double xDistance = point1X - point2X;
        double yDistance = point1Y - point2Y;
        
        
        double angleToPoints = Math.atan2(yDistance , xDistance);

        return Math.toDegrees(angleToPoints);
    }

    public static int newRadialPointFromAngle(int point, double angle, int radiusDistance) {
        int newPoint = (int) (point + angle * radiusDistance);
        return newPoint;
    }

    public static int newYFromAngle(int y, int degree, int radiusDistance) {
        int newY = (int) (y + Math.sin(Math.toRadians(degree)) * radiusDistance);
        return newY;
    }

    public static int newXFromAngle(int x, int degree, int radiusDistance) {
        int newX = (int) (x + Math.cos(Math.toRadians(degree)) * radiusDistance);
        return newX;
    }
    

    public static double newYAngle(double degree) {
        return Math.sin(degree);
    }

    public static double newXAngle(double degree) {
        return Math.cos(degree);
    }
    
    public static int newVelictyXFromAngle(double degree, int speed) {
        double velocity = Math.cos(Math.toRadians(degree)) * speed;
        System.out.println("velocity X b4 cast " + velocity);
        return (int) (Math.round(velocity));
    }

    public static int newVelictyYFromAngle(double degree, int speed) {
        double velocity = Math.sin(Math.toRadians(degree)) * speed;
        System.out.println("velocity Y b4 cast " + velocity);
        return (int) (Math.round(velocity));
    }

}
