/******************************************************************************
 *  Compilation:  javac FunctionsExamples.java
 *  Author:       Nino Lau on 2017-08-12/17:51.
 *  Execution:    none
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Examples of functions.
 *
 ******************************************************************************/

public class FunctionExamples {

    // absolute value of an int value
    public static int abs(int x) { return (x < 0)? -x : x; }

    // absolute value of a double value (overloading)
    public static double abs(double x) { return (x < 0)? -x : x; }

    // primality test (multiple return statements)
    public static boolean isPrime(int n) {
        if (n < 2) return false; 
        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0) return false; 
        return true; 
    }

    // hypotenuse of a right triangle (multiple arguments)
    // see also Math.hypot()
    public static double hypotenuse(double a, double b) { return Math.sqrt(a*a + b*b); }

    // Harmonic number 
    public static double harmonic(int n) {
        double sum = 0.0; 
        for (int i = 1; i <= n; i++) 
            sum += 1.0 / i; 
        return sum; 
    } 

    // uniform random integer in [0, n) 
    public static int uniform(int n) {
        return (int) (Math.random() * n);
    } 

    // draw a triangle to standard draw (side effects)
    public static void drawTriangle(double x0, double y0, double x1, double y1, double x2, double y2) {   
        StdDraw.line(x0, y0, x1, y1); 
        StdDraw.line(x1, y1, x2, y2); 
        StdDraw.line(x2, y2, x0, y0); 
    } 

    public static void main(String[] args) {
    }
}
