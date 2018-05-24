
/******************************************************************************
 *  Compilation:  javac RecursiveTree.java
 *  Execution:    java RecursiveTree n
 *  Author:       Nino  Lau on 2017-08-14/17:28.
 *  Dependencies: StdDraw.java
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Plot a tree fractal.
 *
 *  % java Tree 8
 *
 ******************************************************************************/

public class RecursiveTree {

	// n is the complication of the tree
    public static void RecursiveTree(int n, double x, double y, double a, double branchRadius) {
        double bendAngle = Math.toRadians(10);           // bend angle of tree's growing
        double branchAngle = Math.toRadians(35);           // branches deviate    
        double branchRatio = 0.65;                         // every time narrowed

        double cx = x + Math.cos(a) * branchRadius;
        double cy = y + Math.sin(a) * branchRadius;
        StdDraw.setPenRadius(0.001 * Math.pow(n, 1.2));
        StdDraw.line(x, y, cx, cy);
        if (n == 0) return ;

        // set the left branch 
        RecursiveTree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);
        // set the right branch
        RecursiveTree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);
        // set the bend branch
        RecursiveTree(n-1, cx, cy, a + bendAngle, branchRadius * (1 - branchRatio));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0.01, 3);
        StdDraw.setYscale(0.01, 2);
        StdDraw.enableDoubleBuffering();
        RecursiveTree(n, 1.4, 0.03, Math.PI/2, 0.6);
        StdDraw.show();
    }
}