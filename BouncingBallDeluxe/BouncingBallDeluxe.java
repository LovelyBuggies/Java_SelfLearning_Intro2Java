
/******************************************************************************
 *  Compilation:  javac BouncingBallDeluxe.java
 *  Execution:    java BouncingBallDeluxe
 *  Author:       Nino Leo on 2017-08-11/12:06.
 *  Dependencies: StdDraw.java StdAudio.java
 *  Copyright © 2000–2016, Robert Sedgewick and Kevin Wayne. 
 *
 *  Implementation of a bouncing tennis ball in the box from (-1, -1) to (1, 1),
 *  with sound effects.
 *
 *  % java BouncingBallDeluxe
 *
 ******************************************************************************/

public class BouncingBallDeluxe {

	public static void main(String[] args) {
		// initial value
	    double rx = 0.480, ry = 0.860;                // position of ball
	    double vx = 0.015, vy = 0.023;                // velocity of ball
	    double radius = 0.05;                         // radius of ball
	
	    // set the scale of the coordinate system
	    StdDraw.setXscale(-1.0, 1.0);
	    StdDraw.setYscale(-1.0, 1.0);
	    StdDraw.enableDoubleBuffering();

	    while (true) {

	    	// bounce off wall according to the law of elastic collison
	    	if (Math.abs(rx + vx) + radius > 1.0) {
	    		vx = -vx;
	    		StdAudio.play("pipebang.webarchive");
	    	}
	    	if (Math.abs(ry + vy) + radius > 1.0) {
	    		vy = -vy;
	    		StdAudio.play("pipebang.webarchive");
	    	}

	    	// update the location
	    	rx += vx;
	    	ry += vy;

	    	// set the backgroud to light gray
	    	StdDraw.clear(StdDraw.LIGHT_GRAY);

	    	// draw ball on the screen
	    	StdDraw.picture(rx, ry, "TennisBall.png");

	    	// display and pause for 20 ms
	    	StdDraw.show();
	    	StdDraw.pause(20);
	    }
	}
}