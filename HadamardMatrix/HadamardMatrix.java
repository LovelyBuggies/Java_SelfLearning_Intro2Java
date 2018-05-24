
/******************************************************************************
 *  Compilation:  javac HadamardMatrix.java
 *  Execution:    java HadamardMatrix n
 *  Author:       Nino Leo on 2017-08-10/16:11.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Prints the HadamardMatrix matrix of order n. Assumes n is a power of 2.
 *
 *  % java HadamardMatrix 2
 *  * * 
 *  * . 
 *
 *  % java HadamardMatrix 4
 *  * * * * 
 *  * . * . 
 *  * * . . 
 *  * . . * 
 *
 ******************************************************************************/

public class HadamardMatrix { 
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        boolean[][] hadamard = new boolean[n][n];

        // initialize Hadamard matrix of order n
        hadamard[0][0] = true;
        for (int k = 1; k < n; k += k) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    hadamard[i+k][j]   =  hadamard[i][j];
                    hadamard[i][j+k]   =  hadamard[i][j];
                    hadamard[i+k][j+k] = !hadamard[i][j];
                }
            }
        }

        // print matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hadamard[i][j]) System.out.print("* ");
                else                System.out.print(". ");
            }
            System.out.println();
        }
    }

}