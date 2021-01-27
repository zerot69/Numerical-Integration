package com;

import java.util.Random;

public class Method {
    public static double function(double x){
        return (2*x + 1)*Math.log(x);
    }

    public static double leftRiemannSum(int n){
        double delta = (Main.b-Main.a)/((double) n);
        double sumLeft = 0;
        double x;
        for (int i=0; i<n; i++){
            x = Main.a + (i)*delta;
            sumLeft = sumLeft + delta * function(x);
        }
        System.out.println("Left Riemann Sum = " + sumLeft);
        return sumLeft;
    }

    public static double rightRiemannSum(int n){
        double delta = (Main.b-Main.a)/((double) n);
        double sumRight = 0;
        double x;
        for (int i=1; i<=n; i++){
            x = Main.a + (i)*delta;
            sumRight = sumRight + delta * function(x);
        }
        System.out.println("Right Riemann Sum = " + sumRight);
        return sumRight;
    }

    public static double midpointRule(int n){
        double delta = (Main.b-Main.a)/((double) n);
        double sumMid = 0;
        double x;
        for (int i=0; i<n; i++){
            x = Main.a + (2*i+1)*delta/2;
            sumMid = sumMid + delta * function(x);
        }
        return sumMid;
    }

    public static double trapezoidalRule(int n){
        double delta = (Main.b-Main.a)/((double) n);
        double sumTrap = 0;
        double x1,x2;
        for (int i=0; i<n; i++){
            x1 = Main.a + i*delta;
            x2 = Main.a + (i+1)*delta;
            sumTrap = sumTrap + (delta/2) * (function(x1) + function(x2));
        }
        return sumTrap;
    }

    public static double simpsonsRule(int n){
        double delta = (Main.b-Main.a)/((double) n);
        double sumSimpson = 0;
        double x;
        for (int i=0; i<=n; i++){
            x = Main.a + i*delta;
            if (x == Main.a || x == Main.b){
                sumSimpson = sumSimpson + (delta/3) * (function(x));
            } else if (i % 2 == 1){
                sumSimpson = sumSimpson + (delta/3) * 4 * (function(x));
            } else if (i % 2 == 0){
                sumSimpson = sumSimpson + (delta/3) * 2 * (function(x));
            }
        }
        return sumSimpson;
    }

    public static double MonteCarlo(int n){
        int in = 0;
        int out = 0;
        double min = 0;
        double max = function(Main.b);
        double rectangle = (Main.b-Main.a) * max;
        double x,y;
        for (int i=0; i<n; i++){
            x = Main.a + new Random().nextDouble() * (Main.b - Main.a);
            y = min + new Random().nextDouble() * (max - min);
            if (y > function(x)){
                out++;
            } else {
                in++;
            }
        }
        System.out.println("Number of dots inside = " + in);
        System.out.println("Number of dots outside = " + out);
        return in / ((double) n) * rectangle;
    }
}
