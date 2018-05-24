
/******************************************************************************
 *  Compilation:  javac PermutationsK.java
 *  Execution:    java PermutationsK n k
 *  Author:       Nino Lau on 2017-08-14/15:44.
 *  
 *  Enumerates all permutations of size k chosen from n elements.
 *
 *  % java PermutationsK 4 2 | sort
 *  ab
 *  ac
 *  ad
 *  ba 
 *  bc
 *  bd
 *  ca
 *  cb
 *  cd
 *  da
 *  db 
 *  dc 
 *
 *  Limitations
 *  -----------
 *    *  Assumes n <= 52
 *
 ******************************************************************************/

public class PermutationsK {

    // print n! permutation of the characters of the string s (in order)
    public static void permK(String s, int abandon) { permK("", s, abandon); }

    private static void permK(String prefix, String s, int abandon) {
        int n = s.length();

        // if there isn't any alternate part print the whole prefix string
        if (n == abandon) StdOut.println(prefix);

        // else start alternating
        else {
            for (int i = 0; i < n; i++) {

                // # the next alternate part: prefix + charAt
                // # the left part: substring except part above
                permK(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), abandon);
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        int abandon = n - k;
        permK(elements, abandon);
        StdOut.println();
    }
}
