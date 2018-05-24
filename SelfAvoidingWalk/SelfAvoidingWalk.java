
/******************************************************************************
 *  Compilation:  javac SelfAvoidingWalk.java
 *  Execution:    java SelfAvoidingWalk n trials
 *  Author:       Nino Leo on 2017-08-10/15:06.
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Generate trials self-avoiding walks of length n.
 *  Report the fraction of time the random walk is non self-intersecting.
 *
 ******************************************************************************/

public class SelfAvoidingWalk {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);       // map size
		int trials = Integer.parseInt(args[1]);  // number of trials
		int deadEnds = 0;                        // trials result in dead ends

		// simulate trials self-avoiding walks
		for (int t = 0; t < trials; t++) {
			boolean[][] a = new boolean[n][n];   // intersection visited
			int x = n / 2, y = n / 2;            // current position

			// repeatedly take a random step, unless you've already escaped
			while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {

				// dead end, so break out of loop
				if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
					deadEnds++;
					break;
				}

				// mark (x, y) as visited
				a[x][y] = true;

				// take a random step to unvisted neighbor
				int r = (int) (4 * Math.random());
				switch (r) {
					case 0: if (!a[x + 1][y]) x++; break;
					case 1: if (!a[x - 1][y]) x--; break;
					case 2: if (!a[x][y + 1]) y++; break;
					case 3: if (!a[x][y - 1]) y--; break;
					default: break;
 				} 
			}
		}
		System.out.println(100 * deadEnds / trials + "% dead ends.");
	} 
}