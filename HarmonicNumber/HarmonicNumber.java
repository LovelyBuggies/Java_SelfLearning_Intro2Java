
/******************************************************************************
 *  Compilation:  javac HarmonicNumber.java
 *  Execution:    java HarmonicNumber n
 *  Author:       Nino Leo on 2017-08-03/17:23.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Prints the nth harmonic number: 1/1 + 1/2 + ... + 1/n.
 * 
 *  % java HarmonicNumber 10
 *  2.9289682539682538
 *
 *  % java HarmonicNumber 10000
 *  9.787606036044348
 *
 ******************************************************************************/

public class HarmonicNumber {

    public static void main(String[] args) {

        // Command-line argument parse.
        int n = Integer.parseInt(args[0]);

        // Loop.
        double sum = 0.0;
        for(int i = 1; i <= n; ++i)
            sum += 1.0 / i;

        // Output thew nth harmonic number.
        System.out.println("The nth harmonic number is " + sum + ".");
    }

}