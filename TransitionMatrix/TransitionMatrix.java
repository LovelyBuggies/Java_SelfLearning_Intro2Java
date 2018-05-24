
/******************************************************************************
 *  Compilation:  javac TransitionMatrix.java
 *  Execution:    java TransitionMatrix < input.txt
 *  Author:       Nino Lau on 2017-08-12/17:11.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  This program is a filter that reads links from standard input and
 *  produces the corresponding TransitionMatrix matrix on standard output.
 *  First, it processes the input to count the outlinks from each page.
 *  Then it applies the 90-10 rule to compute the Transition matrix.
 *  It assumes that there are no pages that have no outlinks in the
 *  input (see Exercise 1.6.3).
 *
 *  % more tiny.txt
 *  5 
 *  0 1 
 *  1 2  1 2 
 *  1 3  1 3  1 4 
 *  2 3 
 *  3 0 
 *  4 0  4 2 
 *
 *  % java TransitionMatrix < tiny.txt
 *  5 5
 *   0.02 0.92 0.02 0.02 0.02
 *   0.02 0.02 0.38 0.38 0.20
 *   0.02 0.02 0.02 0.92 0.02
 *   0.92 0.02 0.02 0.02 0.02
 *   0.47 0.02 0.47 0.02 0.02
 *
 ******************************************************************************/

public class TransitionMatrix {

	public static void main(String[] args) {

		int n = StdIn.readInt();                 // number of pages
		int[][] counts = new int[n][n];          // links from page i to page j
		int[] outDegree = new int[n];            // links of page i

		// Accumulate link counts
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			counts[p][q]++;
			outDegree[p]++;
		}
		StdOut.println(n + " " + n);

		// Print probability distribution for row i
		for (int i = 0; i < n; i++) {

			// print the posibility for column j.
			for (int j = 0; j < n; j++) {
				System.out.printf("%-5.2f", 0.90 * counts[i][j] / outDegree[i] + 0.10 / n);
			}
			System.out.println();
		}
	}

}