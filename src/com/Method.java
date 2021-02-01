package com;

/*
Methods of Numerical Integration
Author: Vo-Hoang-Tuan Ngo (26839); Lam-Bao-Hieu Truong (27391);
Rhein-Waal University of Applied Sciences
Date 25.01.2021
*/

import java.util.Random;

public class Method {
    public static double function(double x){
        return (2*x + 1)*Math.log(x); // Here you can change f(x) into another function
    }

    // Left Riemann Sum
    // = ∆x * ( f(a) + f(a+∆x) + f(a+2∆x) + f(a+3∆x) + ... + f(b-∆x) )
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

    // Right Riemann Sum
    // = ∆x * ( f(a+∆x) + f(a+2∆x) + ... + f(b-∆x) + f(b) )
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

    // Midpoint Rule
    // = ∆x * ( f(a+∆x/2) + f(a+3∆x/2) + f(a+5∆x/2) + ... + f(b-∆x/2) )
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

    // Trapezoidal Rule
    // = ∆x/2 * ( f(a) + 2f(a+∆x) + 2f(a+2∆x) + ... + 2f(b-∆x) + f(b) )
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

    // Simpson's Rule
    // = ∆x/3 * ( f(x_0) + 4f(x_1) + 2f(x_2) + 4f(x_3) + 2f(x_4) + ... + f(x_n) )
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

    /* Monte Carlo's Simulation
    Input n = The total number of dots = Loops n times
    In each loop, random 2 numbers x and y => The location of the random dot (x,y)
    If y > f(x) => Over the curve => The dot is outside the area => Counter 'out' increase by 1
    If y <= f(x) => Under the curve => The dot is inside the area => Counter 'in' increase by 1
    Integral = in / n * rectangle area
    */
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
