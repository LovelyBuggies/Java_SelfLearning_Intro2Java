
/******************************************************************************
 *  Compilation:  javac ArrayFunctionExamples.java
 *  Execution:    none
 *  Author:       Nino Lau on 2017-08-13/10:18.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Examples of functions that take arrays as arguments or return arrays.
 *
 ******************************************************************************/

public class ArrayFunctionExamples {

	// return the mean of the array
	public static double mean(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) 
			sum += a[i];
		return sum / a.length;
	}

	// swaps array elements i and j
	public static void exchange(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// returns a random integer between 0 and n-1
    public static int uniform(int n) {
        return (int) (Math.random() * n);
    }

    // take as input an array of strings and rearrange them in random order
    public static void shuffle(String[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);   // between i and n-1
            exchange(a, i, r);
        }
    }

    // returns the dot product of a[] and b[]
    public static double dot(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++)
            sum += a[i] * b[i];
        return sum;
    }

    // prints a one-dimensional array and its length
    public static void print(double[] a) {
        StdOut.println(a.length);
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    // reads a two-dimensional array from standard input
    public static double[][] readDouble2D() {
        int m = StdIn.readInt();
        int n = StdIn.readInt();
        double[][] a = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readDouble();
        return a;
    }

    // returns a sine wave of given frequency and duration (sampling rate = 44,100)
    public static double[] tone(double hz, double duration) {
        int SAMPLING_RATE = 44100;
        int n = (int) (SAMPLING_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++)
            a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
        return a;
    }

    public static void main(String[] args) {
    }
}

