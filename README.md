# Numerical-Integration
Methods of Numerical Integration, implemented using Java

## The function f(x)
In default, the function f(x) is ```f(x) = (2x+1)*ln(x)```. This can be changed by replacing with the new function of the method *Method.funtion()*
```java
public static double function(double x){
    return (2*x + 1)*Math.log(x); // Here you can change f(x) into another function
}
```

## Left Riemann Sum
Left Riemann Sum of f(x) over [a,b] can be calculated as ```Sum = ∆x * ( f(a) + f(a+∆x) + f(a+2∆x) + f(a+3∆x) + ... + f(b-∆x) )``` with ```∆x = (b-a)/n``` 

```java
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
```

## Right Riemann Sum
Right Riemann Sum of f(x) over [a,b] can be calculated as ```Sum = ∆x * ( f(a+∆x) + f(a+2∆x) + ... + f(b-∆x) + f(b) )``` with ```∆x = (b-a)/n``` 

```java
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
```

## Midpoint Rule
Midpoint Rule of f(x) over [a,b] can be calculated as ```Sum = ∆x * ( f(a+∆x/2) + f(a+3∆x/2) + f(a+5∆x/2) + ... + f(b-∆x/2) )``` with ```∆x = (b-a)/n``` 

```java
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
```

## Trapezoidal Rule
Trapezoidal Rule of f(x) over [a,b] can be calculated as ```Sum = ∆x/2 * ( f(a) + 2f(a+∆x) + 2f(a+2∆x) + ... + 2f(b-∆x) + f(b) )``` with ```∆x = (b-a)/n``` 

```java
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
```

## Simpson's Rule
Simpson's Rule of f(x) over [a,b] can be calculated as ```Sum = ∆x/2 * ( f(a) + 2f(a+∆x) + 2f(a+2∆x) + ... + 2f(b-∆x) + f(b) )``` with ```∆x = (b-a)/n``` 

```java
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
```

## Monte Carlo's Simulation
In this simulation, a number ```n``` will be inputted. This number is the total number of random dots. Therefore the randomization of dots will be looped *n* times.
In each loop, 2 numbers x and y, satisfy the conditionsa <= x <= b and f(a) <= y <= f(b), are randomized. These 2 numbers are the location of the random dot (x,y).
If y > f(x), the dot is outside the area, then the counter ```out``` is increased by 1. Otherwise, if y <= f(x), the dot is inside the area and the counter ```in``` is increased by 1.
After *n* loops, the approximation of the area under the curve of f(x) over the closed interval [a,b] is returned as ```in / n * rectangle area```

```java
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
```
