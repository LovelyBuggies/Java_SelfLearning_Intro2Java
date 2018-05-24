
/******************************************************************************
 *  Compilation:  javac Permutations.java
 *  Execution:    java Permutations n
 *  Author:       Nino Lau on 2017-08-14/12:04.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Enumerates all permutations on n elements.
 *  Two different approaches are included.
 *
 *  % java Permutations 3
 *  abc
 *  acb
 *  bac 
 *  bca
 *  cab
 *  cba
 *
 ******************************************************************************/

public class Permutations {

    // print n! permutation of the characters of the string s (in order)
    public static void perm(String s) { perm("", s); }

    private static void perm(String prefix, String s) {
        int n = s.length();

        // if there isn't any alternate part print the whole prefix string
        if (n == 0) StdOut.println(prefix);

        // else start alternating
        else {
            for (int i = 0; i < n; i++) {

                // # the next alternate part: prefix + charAt
                // # the left part: substring except part above
                perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        perm(elements);
        StdOut.println();
    }
}