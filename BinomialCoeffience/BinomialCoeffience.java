
/******************************************************************************
 *  Compilation:  javac BinomialCoeffience.java
 *  Execution:    java BinomialCoeffience n
 *  Author:       Nino Leo on 2017-08-10/17:14
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Output the Pascal Triangle with the command-line argument n
 *  And Output the BinomialCoeffience corresponded.
 *
 ******************************************************************************/

public class BinomialCoeffience {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);            // the scale of the matrix
		int[][] tri = new int[n][n];                  // Pascal Triangle matrix
		
		// initial the first element in the every row
		for (int i = 0; i < n; i++)
			tri[i][0] = 1;

		// # tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j]
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++)
				tri[i][j] = tri[i - 1][j] + tri[i - 1][j - 1];
		}

		// print the Pascal Triangle
		System.out.println("Pascal's triangle");
		System.out.println("----------------------------------------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tri[i][j] != 0) System.out.print(tri[i][j] + " ");
			}
			System.out.println();
		}

		// # dis[i][j] = tri[i][j] / 2's factorial
		double[][] dis = new double[n][n];
		dis[0][0] = 1;
		for (int i = 1; i < n; i++)
			for (int j = 0; j <= i; j++)
				dis[i][j] = tri[i][j] / Math.pow(2, i);

		// print the Binomial distribution
		System.out.println("\nBinomial distribution");
		System.out.println("----------------------------------------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dis[i][j] != 0) System.out.print(dis[i][j] + " ");
			}
			System.out.println();
		}
	}

}