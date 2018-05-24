
/******************************************************************************
 *  Compilation:  javac OneSimpleAttractor.java
 *  Execution:    java OneSimpleAttractor
 *  Author:       Nino Lau 2017-08-11/21:02.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  A particle is attracted to the current location of the mouse.
 *  Incorporates drag.
 *
 *  
 *  % java OneSimpleAttractor
 *
 *
 *  Credits:  Jeff Traer-Bernstein
 *
 ******************************************************************************/

public class OneSimpleAttractor {

    public static void main(String[] args) {
        double rx = 0.0, ry = 0.0;   			// position of ball
        double vx = 0.0, vy = 0.0;				// velocity of ball
        double mass = 1.0;           			// mass of the ball
        double dt   = 0.5;         				// time increase quantum
        double drag = 0.1;           			// mess around with this a bit
        double attractionStrength = 0.01;
        
        // do the animation
        StdDraw.enableDoubleBuffering();
        while (true) {

            // compute the attractive force to the mouse, accounting for drag
            double dx = StdDraw.mouseX() - rx;						// distance of X-coordinate 
            double dy = StdDraw.mouseY() - ry;						// distancd of Y-coordinate
            double fx = (dx * attractionStrength) - (drag * vx);	// the composition force of X-coordinate
            double fy = (dy * attractionStrength) - (drag * vy);    // the composition force of Y-coordinate
            double ax = fx / mass;									// acceleration of X-coordinate
            double ay = fy / mass;									// acceleration of Y-coordinate
    
            // Euler step: update velocity, then position
            vx += ax * dt;
            vy += ay * dt;
            rx += vx * dt;
            ry += vy * dt;
            
            // draw particle
            StdDraw.clear(StdDraw.LIGHT_GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, 0.02);
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}


