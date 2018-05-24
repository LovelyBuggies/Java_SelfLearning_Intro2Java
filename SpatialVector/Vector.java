/******************************************************************************
 *  Compilation:  javac Vector.java
 *  Execution:    java Vector
 *  Author:       Nino Lau on 2017-08-19/10:04.
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Implementation of a vector of real numbers.
 *
 *  This class is implemented to be immutable: once the client program
 *  initialize a Vector, it cannot change any of its fields
 *  (N or data[i]) either directly or indirectly. Immutability is a
 *  very desirable feature of a data type.
 *
 *
 *  % java Vector
 *  x        =  (1.0, 2.0, 3.0, 4.0)
 *  y        =  (5.0, 2.0, 4.0, 1.0)
 *  x + y    =  (6.0, 4.0, 7.0, 5.0)
 *  10x      =  (10.0, 20.0, 30.0, 40.0)
 *  |x|      =  5.477225575051661
 *  <x, y>   =  25.0
 *  |x - y|  =  5.0990195135927845
 *
 *  Note other java.util.Vector is an unrelated Java library class.
 *
 ******************************************************************************/

public class Vector {
	private final int n;
	private double[] data;

	// creat the zero vector of dimension n
	public Vector(int n) {
		this.n = n;
		this.data = new double[n];
	}

	// creat a vector from an array
	public Vector(double[] data) {
		n = data.length;

		// defensive copy
		this.data = new double[n];
		for (int i = 0; i < n; i++) {
			this.data[i] = data[i];
		}
	}

	// length of the vector
	public int length() {
		return n;
	}

	// return the inner product of this Vector a and b
	public double dot(Vector other) {
		if (this.length() != other.length())
            throw new IllegalArgumentException("dimensions disagree");
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			sum += this.data[i] * other.data[i];
		}
		return sum;
	}

	// return the Euclidean norm of this Vector
	public double magnitude() {
		return Math.sqrt(this.dot(this));
	}

	// return the Euclidean distance betweem two vector
	public double distanceTo(Vector other) {
		if (this.length() != other.length())
			throw new IllegalArgumentException("dimensions disagree");
		return this.minus(other).magnitude();
	}

	// return this + other
	public Vector plus(Vector other) {
		if (this.length() != other.length())
			throw new IllegalArgumentException("dimensions disagree");
		Vector c = new Vector(n);
		for (int i = 0; i < n; i++) {
			c.data[i] = this.data[i] + other.data[i];
		}
		return c;
	}

	// return this - other
	public Vector minus(Vector other) {
        if (this.length() != other.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] - other.data[i];
        return c;
    }

    // return the corresponding coordinate
    public double cartesian(int i) {
    	return data[i];
    }

    // creat and return a new object whose value is (this * factor)
    public Vector scale(double factor) {
    	Vector c = new Vector(n);
    	for (int i = 0; i < n; i++) {
    		c.data[i] = factor * data[i];
    	}
    	return c;
    }

    // return the corresponding unit vector
    public Vector direction() {
    	if (this.magnitude() == 0.0) 
    		throw new ArithmeticException("zero-vector has no direction");
    	return this.scale(1.0 / this.magnitude());
    }

    // return a string representation of the vector
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	s.append('(');
    	for (int i = 0; i < n; i++) {
    		s.append(data[i]);
    		if (i < n - 1) s.append(", ");
    	}
    	s.append(')');
    	return s.toString();
    }

        // test client
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        StdOut.println("x        =  " + x);
        StdOut.println("y        =  " + y);
        StdOut.println("x + y    =  " + x.plus(y));
        StdOut.println("10x      =  " + x.scale(10.0));
        StdOut.println("|x|      =  " + x.magnitude());
        StdOut.println("<x, y>   =  " + x.dot(y));
        StdOut.println("|x - y|  =  " + x.minus(y).magnitude());
    }
}

