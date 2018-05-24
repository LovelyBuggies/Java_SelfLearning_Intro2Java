
/******************************************************************************
 *  Compilation:  javac Triangle.java
 *  Execution:    java Triangle
 *  Author:       Nino  Leo on 2017-08-11/09:03.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000-2011, Robert Sedgewick and kevin Wayne.
 *
 *  Plot a triangle.
 *
 ******************************************************************************/

public class Triangle {

	public static void main(String[] args) {
		double t = Math.sqrt(3.0) / 2.0;
		StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);
        StdDraw.point(0.5, t/3.0);
	}

}