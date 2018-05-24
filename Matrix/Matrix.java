
/******************************************************************************
 *  Compilation:  javac Matrix.java
 *  Execution:    java Matrix
 *  Author:       Nino Lau on 2017-08-13/21:00.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  The implementation of Matrix API
 *
 *
 ******************************************************************************/

public class Matrix {

	// return a random m-by-n matrix with values between 0 and 1
	public static double[][] random(int m, int n) {
		double a[][] = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = StdRandom.uniform(0.0, 1.0);
			}
		}
		return a;
	}

	// creat an identity matrix
	public static double[][] identity(int n) {
		double[][] a = new double[n][n];
		for (int i = 0; i < n; i++) {
			a[i][i] = 1;
		}
		return a;
	}

	// calculate the dot of two vectors
	public static double dot(double[] a, double[] b) {
		if (a.length != b.length) throw new RuntimeException("Illegal vector dimension.");
		double sum = 0.0;
		for (int i  = 0; i < a.length; i++) {
			sum += a[i] * b[i];
		}
		return sum;
	}

	// transpose the matrix
	public static double[][] transpose(double[][] a) {
		int m = a.length;
		int n = a[0].length;
		double[][] b = new double[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;
	}

	// plus of two matrices
	public static double[][] add(double[][] a, double[][] b) {
		if(a.length != b.length || a[0].length != b[0].length) throw new RuntimeException("Illegal matrix addition.");
		double[][] c = new double[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	// subtraction of two matrice
    public static double[][] subtract(double[][] a, double[][] b) {
		if(a.length != b.length || a[0].length != b[0].length) throw new RuntimeException("Illegal matrix subtraction.");
		double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                c[i][j] = a[i][j] - b[i][j];
        return c;
    }

    // mutiplication of two matrice
    public static double[][] multiply(double[][] a, double[][] b) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] c = new double[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    // test client
    public static void main(String[] args) {
        StdOut.println("D");
        StdOut.println("--------------------");
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        StdArrayIO.print(d);
        StdOut.println();

        StdOut.println("I");
        StdOut.println("--------------------");
        double[][] c = Matrix.identity(5);
        StdArrayIO.print(c);
        StdOut.println();

        StdOut.println("A");
        StdOut.println("--------------------");
        double[][] a = Matrix.random(5, 5);
        StdArrayIO.print(a);
        StdOut.println();

        StdOut.println("A^T");
        StdOut.println("--------------------");
        double[][] b = Matrix.transpose(a);
        StdArrayIO.print(b);
        StdOut.println();

        StdOut.println("A + A^T");
        StdOut.println("--------------------");
        double[][] e = Matrix.add(a, b);
        StdArrayIO.print(e);
        StdOut.println();

        StdOut.println("A * A^T");
        StdOut.println("--------------------");
        double[][] f = Matrix.multiply(a, b);
        StdArrayIO.print(f);
        StdOut.println();
    }
}