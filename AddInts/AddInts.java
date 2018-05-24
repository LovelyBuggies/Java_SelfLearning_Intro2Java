
/******************************************************************************
 *  Compilation:  javac -cp (path): stdlib.jar AddInts.java
 *  Execution:    java -cp (path): stdlib.jar AddInts
 *  Author:       Nino Leo on 2017-08-10/20:59.
 *  Dependencies: StdIn.java StdOut.java
 *  Copyright © 2000 - 2011, Robert Sedgewick and Kevin Wayne.
 *  
 *  This program takes a command-line argument n, reads in n integers,
 *  and prints out their sum.
 *
 *  % java AddInts n
 *
 ******************************************************************************/

public class AddInts { 
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int value = StdIn.readInt();
            sum = sum + value;
        }
        StdOut.printf("Sum is %-5d", sum);
    }
}

