
/******************************************************************************
 *  Compilation:  javac BouncingBall.java
 *  Execution:    java BouncingBall
 *  Author:       Nino Leo on 2017-08-11/11:25.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *  
 *  Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
 *
 *  % java BouncingBall
 *
 ******************************************************************************/

public class BouncingBall {
	public static void main(String[] args) {

		// set the scale of the coordinate system
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.enableDoubleBuffering();

		// initial values
		double rx = 0.500, ry = 0.500;         // position of ball
		double vx = 0.035, vy = 0.055;         // velocity of ball
		double radius = 0.05;                  // radius of ball

		// main animation loop
		while (true) {

			// bounce off wall according to the law of elastic collision
			if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
			if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

			// update position
			rx += vx;
			ry += vy;

			// clear the background
			StdDraw.clear(StdDraw.LIGHT_GRAY);

			// draw ball on the screen
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(rx, ry, radius);

			// copy offscreen buffer to onscreen
			StdDraw.show();

			// pause for 20 ms
			StdDraw.pause(20);
		}
	}
}