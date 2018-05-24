
/******************************************************************************
 *  Compilation:  javac Horner.java
 *  Execution:    java Horner
 *  Author:       Nino Lau on 2017-08-13/11:47.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne.
 *  
 *  A static method for evaluating a polynomial using Horner's method.
 *
 *  The test client takes a command-line argument n, computes n terms
 *  of the Taylor series e^x = 1 + x + x^2/2! + ..., and reads in
 *  values x from standard input, and prints out the polynomial
 *  evaluates at x (and compares it against Math.exp(x)).
 *
 *  % java Horner 30
 *  0
 *  1.0
 *  1.0
 *
 *  1
 *  2.718
 *  2.718
 *
 *  2
 *  7.389
 *  7.389
 * 
 *  .5
 *  1.648
 *  1.648
 *
 *  -.1
 *  0.904
 *  0.904
 *
 ******************************************************************************/

public class Horner { 

    // use Horner's method to compute and return the polynomial evaluated at x
    // p[0] + p[1] x^1 + p[2] x^2 + ... + p[n-1] x^n-1 
    public static double eval(double x, double[] p) {
        double result = 0;
        for (int i = 0; i < p.length; i++)
            result += p[i] * Math.pow(x, i);
        return result;
    }


    // compute the factorial of unsign integer
    
    /******************************************
     * public static int factorial(int n) {
     * 	int fac = 1;
     *	for (int i = 1; i <= n; i++) {
     *		fac *= i;
     * 	}
     *	return fac;
     * }
     ******************************************/

    public static void main(String[] args) { 

    	// n is the accuracy of the Taylor
        int n  = Integer.parseInt(args[0]);

        // compute coeffients for Taylor series e^x = 1 + x + x^2/2! + x^3/3! + ...
        
        // this method may cause a little mistake 
        // due to the quantum calculation
        /**************************************************
         * double[] p = new double[n];
         * for (int i = 0; i < n; i++) {
         *    p[i] = (double) 1.0 / (double) factorial(i);
         * } 
         **************************************************/

        double[] p = new double[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i-1] / i;
        }

        // evaluate the polynomial at values x read from standard input
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            StdOut.printf("%.3f\n",eval(x, p));
            StdOut.printf("%.3f\n",Math.exp(x));
            StdOut.println();
        }
    }
}
