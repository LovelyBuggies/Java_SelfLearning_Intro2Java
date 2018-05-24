/******************************************************************************
 *  Compilation:  javac Spirograph.java
 *  Execution:    java Spirograph R r a
 *  Author:       Nino Lau on 2017-08-12/15:49.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Draw a curve formed by rolling a smaller circle of radius r inside
 *  a larger circle or radius R. If the pen offset of the pen point in
 *  the moving circle is a, then the equation of the resulting curve
 *  at time t is
 *
 *     x = (R+r)*cos(t) - (r+a)*cos(((R+r)/r)*t)
 *     y = (R+r)*sin(t) - (r+a)*sin(((R+r)/r)*t)
 *
 *  % java Spirograph 180 40 15
 *
 *  % java Spirograph 100 55 20
 *
 *  Credits: idea suggested by Diego Nehab
 *  Reference: http://www.math.dartmouth.edu/~dlittle/java/SpiroGraph
 *  Reference: http://www.wordsmith.org/~anu/java/spirograph.html
 *
 ******************************************************************************/

public class Spirograph {

	public static void main(String[] args) {
		
		// parse R, r and a
		double R = Integer.parseInt(args[0]);
		double r = Integer.parseInt(args[1]);
		double a = Integer.parseInt(args[2]);

		StdDraw.setXscale(-300, 300);
		StdDraw.setYscale(-300, 300);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.enableDoubleBuffering();

		for(double t = 0.0; t < 360.0; t += 0.1) {
			double x = (R + r) * Math.cos(t) - (r + a) * Math.cos(((R + r) / r) * t);
			double y = (R + r) * Math.sin(t) - (r + a) * Math.sin(((R + r) / r) * t);
			double degrees = -Math.toDegrees((R+r)/r)*t;
            StdDraw.picture(x, y, "earth.gif", degrees);
            StdDraw.show();
            StdDraw.pause(20);
		}
	}

}