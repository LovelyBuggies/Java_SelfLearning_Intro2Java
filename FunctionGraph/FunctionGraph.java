
/******************************************************************************
 *  Compilation:  javac FunctionGraph.java 
 *  Execution:    java FunctionGraph n
 *  Author:       Nino Leo on 2017-08-11/10:05.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000-2011, Rober Sedgewick and Kevin Wayne.
 *
 *  Plots the function y = sin(4x) + sin(20x) between x = 0 and x = pi
 *  by drawing n line segments.
 *
 ******************************************************************************/

public class FunctionGraph {

	public static void main(String[] args) {

		// number of line segements to plot
		int n = Integer.parseInt(args[0]);

		// the function y = sin(4x) + sin(20x), sampled at n+1 points
		double[] x = new double[n + 1];
		double[] y = new double[n + 1];
		for(int i = 0; i <= n; i++) {
			x[i] = Math.PI * i / n;
			y[i] = Math.sin(4 * x[i]) + Math.sin(20 * x[i]);
		}

		// rescale the coordinate system
		StdDraw.setXscale(0, Math.PI);
		StdDraw.setYscale(-2.0, +2.0);

		// plot the approximation to the function
		for(int i = 0; i < n; i++)
			StdDraw.line(x[i], y[i], x[i + 1], y[i + 1]);
	}

}