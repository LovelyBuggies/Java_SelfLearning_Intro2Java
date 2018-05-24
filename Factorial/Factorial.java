
/******************************************************************************
 *  Compilation:  javac Factorial.java
 *  Execution:    java Factorial n
 *  Author:       Nino Lau on 2017-08-14/09:00.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Reads an integer command-line argument n, and prints n! = 1 * 2 * ... * n
 *  to standard output.
 *
 *  % java Factorial 0
 *  1
 *
 *  % java Factorial 1
 *  1
 *
 *  % java Factorial 5
 *  120
 *
 *
 *  % java Factorial -10
 *  java.lang.RuntimeException: Underflow error in factorial
 *
 *  % java Factorial 21
 *  java.lang.RuntimeException: Overflow error in factorial
 *
 *
 *  Remarks
 *  -------
 *   - Would overflow a long if n > 20
 *   - Need to use extended precision arithmetic to handle bigger factorials
 *
 ******************************************************************************/

public class Factorial {

	public static int fac(int n) {
		if (n < 0) throw new RuntimeException("Underflow error in factorial.");
		if (n > 20) throw new RuntimeException("Overflow error in factorial.");
		if (n == 0) return 1;
		else return n * fac(n - 1);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		System.out.println(fac(n));
	}

}