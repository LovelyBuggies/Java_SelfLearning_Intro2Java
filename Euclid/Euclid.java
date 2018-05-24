  
/******************************************************************************
 *  Compilation:  javac Euclid.java
 *  Execution:    java Euclid p q
 *  Author:       Nino Lau on 2017-08-14.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Reads two command-line arguments p and q and computes the greatest
 *  common divisor of p and q using Euclid's algorithm.
 * 
 *  Reads tow command-line arguments p and q and computes their leastest
 *  common mutiplication of p and q using the GCD calculated.
 *
 *  Remarks
 *  -----------
 *    - may return the negative of the gcd if p is negative
 *
 ******************************************************************************/

public class Euclid {

	// recursive implementation
	public static int gcd(int p, int q) {
		return q == 0? p : gcd(q, p % q);
	}

	// non-recursive implementation
	public static int gcd2(int p, int q) {
		while(q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}

	// lcm = p * q / gcd
	public static int lcm(int p, int q) {
		return p * q / gcd(p, q);
	}

	public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        int m = lcm(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd2(" + p + ", " + q + ") = " + d2);
        System.out.println("lcm(" + p + ", " + q + ") = " + m);
	}

}