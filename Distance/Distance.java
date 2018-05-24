
/******************************************************************************
 *  Compilation:  javac Distance.java
 *  Execution:    java Distance x y
 *  Author:       Nino Leo on 2017-08-03/15:12.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Prints the distance from (x, y) to the origin, where x and y
 *  are integers.
 * 
 *  % java Distance 3 4
 *  distance from (3, 4) to (0, 0) = 5.0
 *
 *  % java Distance 5 12
 *  distance from (5, 12) to (0, 0) = 13.0
 *
 *  % java Distance 2 1
 *  distance from (2, 1) to (0, 0) = 2.23606797749979
 *
 ******************************************************************************/

public class Distance {

	public static void main(String[] args) {

		// Parse x- and y-coordinates from command-line arguments.
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);

		// Compute distance to the original point.
		double dist = Math.sqrt(x * x + y * y);

		// Print the distance.
		System.out.println("distance from (" + x + ", " + y + ") to (0, 0) = " + dist);
	}

}