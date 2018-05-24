/******************************************************************************
 *  Compilation:  javac Stats.java
 *  Execution:    java Stats n
 *  Author:       Nino Leo on 2017-08-12/09:34.
 *  Dependencies: StdIn.java StdOut.java
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Reads in a command-line integer n, a sequence of n real numbers from
 *  standard input, and prints the mean and sample standard deviation.
 *
 *  % java Stats 6
 *  10.0 5.0 6.0
 *  3.0 7.0 32.0
 *  [EOF]
 *  Mean                      = 10.5
 *  Sample standard deviation = 10.784247771634329
 *
 ******************************************************************************/

public class Stats { 
    
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        double[] a = new double[n];

        // read data and compute statistics
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readDouble();
        }

        // compute mean
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        double mean = sum / n;

        // compute standard deviation
        double sum2 = 0.0;
        for (int i = 0; i < n; i++) {
            sum2 += (a[i] - mean) * (a[i] - mean);
        }
        double stddev = Math.sqrt(sum2 / (n - 1));

        // print results
        StdOut.println("Mean                      = " + mean);
        StdOut.println("Sample standard deviation = " + stddev);
    }
}
