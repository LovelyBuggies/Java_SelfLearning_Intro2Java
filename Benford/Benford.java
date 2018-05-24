
/******************************************************************************
 *  Compilation:  javac Benford.java StdIn.java
 *  Execution:    java Benford < data.txt
 *  Author:       Nino Lau on 2017-08-13/19:59.
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *  
 *  Reads in a sequence of integers and computes a frequency distribution
 *  of the number of times 1-9 is the leading (leftmost) digit.
 *
 *  Benford's law predicts that for many real-world data sets:
 *
 *  % java Benford < 1Kints.txt
 *
 *  1:   16.0%
 *  2:   11.3%
 *  3:    9.4%
 *  4:   10.1%
 *  5:    9.7%
 *  6:   10.2%
 *  7:   12.8%
 *  8:   10.5%
 *  9:   10.0%
 *
 ******************************************************************************/

public class Benford {

	// return the leading digit of an integer n
	public static int leadingDigit(int n) {
		while (n >= 10) {
			n /= 10;
		}
		return n;
	}

	public static void main(String[] args) {

		int[] count = new int[10];    // frequency of leading digit i
		int sum = 0;                  // totally read

		// statistical counting
		while (!StdIn.isEmpty()) {
			sum++;
			int x = StdIn.readInt();
			int digit = leadingDigit(x);
			count[digit]++;
		}

		for (int i = 1; i < 10; i++)
			StdOut.printf("%d: %6.1f%%\n", i, 100 * (double) count[i] / sum);
	}

}