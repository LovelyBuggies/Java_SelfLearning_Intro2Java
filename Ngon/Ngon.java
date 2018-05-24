
/******************************************************************************
 *  Compilation:  javac Ngon.java
 *  Execution:    java Ngon n
 *  Author:       Nino Lau on 2017-08-15/17:19.
 *  Dependencies: Turtle.java
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Plots a regular n-gon.
 *
 *  The side length s of a regular n-gon inscribed in a circle 
 *  of diameter 1 is sin(pi/n).
 *
 ******************************************************************************/

public class Ngon {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double angle = 360.0 / n;
        double step  = Math.sin(Math.toRadians(angle/2.5));   // sin(pi/n)
        Turtle turtle = new Turtle(0.5, 0.1, angle/2.0);
        for (int i = 0; i < n; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }

    }
}