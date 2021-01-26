package com;

/*
Methods of Numerical Integration
Author: Vo-Hoang-Tuan Ngo (26839); Lam-Bao-Hieu Truong (27391);
Rhein-Waal University of Applied Sciences
Date 25.01.2021
*/

import java.util.Scanner;

public class Main {

    // Closed interval from a to b: [1,9]
    final static int a = 1;
    final static int b = 9;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("f(x) = (2x+1)*ln(x)");
        System.out.println("Calculate the integral of f(x)dx over the closed interval [1,9]");
        System.out.println("Method:");
        System.out.println("1. Riemann Sum");
        System.out.println("2. Midpoint Rule");
        System.out.println("3. Trapezoidal Rule");
        System.out.println("4. Simpson's Rule");
        System.out.println("X. Exit");
        System.out.println("\nChoose a method: ");
        String input = "";

        while (!input.equalsIgnoreCase("X")){
            input = scanner.nextLine().trim();

            // Riemann Sum
            if (input.equals("1")){
                System.out.println("\nRiemann Sum");
                System.out.println("Number of sub-intervals:");
                int n = scanner.nextInt();
                double leftRiemannSum = Method.leftRiemannSum(n);
                double rightRiemannSum = Method.rightRiemannSum(n);
                double averageRiemannSum = (leftRiemannSum + rightRiemannSum)/2;
                System.out.println("Integral ≈ (Left + Right) / 2 = " + averageRiemannSum);
            }

            // Midpoint Rule
             else if (input.equals("2")){
                System.out.println("\nMidpoint Rule");
                System.out.println("Number of sub-intervals:");
                int n = scanner.nextInt();
                double midpointRule = Method.midpointRule(n);
                System.out.println("Integral ≈ Midpoint Rule Sum = " + midpointRule);
            }

            // Trapezoidal Rule
            else if (input.equals("3")){
                System.out.println("\nTrapezoidal Rule");
                System.out.println("Number of sub-intervals:");
                int n = scanner.nextInt();
                double trapezoidalRule = Method.trapezoidalRule(n);
                System.out.println("Integral ≈ Trapezoidal Rule Sum = " + trapezoidalRule);
            }

            // Simpson's Rule
            else if (input.equals("4")){
                System.out.println("\nSimpson's 1/3 Rule");
                System.out.println("Number of sub-intervals:");
                int n = scanner.nextInt();
                double simpsonsRule = Method.simpsonsRule(n);
                System.out.println("Integral ≈ Simpson's Rule Sum = " + simpsonsRule);
            }

            // Exit
            else if (input.equalsIgnoreCase("X")){
                break;
            }
        }
        System.out.println("Exit!");
    }

}
