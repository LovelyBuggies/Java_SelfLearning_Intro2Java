
/******************************************************************************
 *  Compilation:  javac SimpleAttractors.java
 *  Execution:    java SimpleAttractors n
 *  Author:       Nino Lau on 2017-09-11/21:29.
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *  Dependencies: StdDraw.java
 *
 *  n particles are attracted to the mouse; randomly rearrange when
 *  user clicks the mouse.
 *
 *  % java SimpleAttractors 20
 *
 *  Credits:  Jeff Traer-Bernstein
 * 
 ******************************************************************************/

public class SimpleAttractors {

	public static void main(String[] args) {
		// read the number of particles
		int n = Integer.parseInt(args[0]);
		double[] rx = new double[n];			// the postion of the particles
		double[] ry = new double[n];
		double[] vx = new double[n];			// the velocity of the particles
		double[] vy = new double[n];
		double dt = 0.5;						// increase quantum of time
		double mass = 1.0; 						// the mass of the particles
		double drag = 0.05;						
		double attractionStrength = 0.01;

		// initialize the drawing area
		StdDraw.setPenColor(StdDraw.BLUE);

		// do the animation
		StdDraw.enableDoubleBuffering();
		while (true) {

			// if the mouse is pressed add randome velocity to articles
			if (StdDraw.mousePressed()) {
				for (int i = 0; i < n; i++) {
					vx[i] = 0.2 * Math.random() - 0.1;
					vy[i] = 0.2 * Math.random() - 0.1;
				}
			}

			// clear all the forces
			double[] fx = new double[n];
			double[] fy = new double[n];
			
			// add attraction forces for attraction to the mouse
			// # attractionStrength * dx is the attraction force generate by distance
			// # drag * vy[i] is the force generate by buffering
			// fx[] is the composition force of the particles
            for (int i = 0; i < n; i++) {
                double dx = StdDraw.mouseX() - rx[i];
                double dy = StdDraw.mouseY() - ry[i];
                fx[i] += attractionStrength * dx - drag * vx[i];
                fy[i] += attractionStrength * dy - drag * vy[i]; 
            }
           	   
           	// update positions
            for (int i = 0; i < n; i++) {
                vx[i] += fx[i] * dt / mass;
                vy[i] += fy[i] * dt / mass;
                rx[i] += vx[i] * dt;
                ry[i] += vy[i] * dt;
            }

            // forget the forward screen
            StdDraw.clear();

            // draw a filled circle for each particle
            for (int i = 0; i < n; i++) {
            	StdDraw.filledCircle(rx[i], ry[i], 0.01);
            }

            // show the particles
            StdDraw.show();

            // renew the screen every 10 ms
            StdDraw.pause(10);
		}
	}

}