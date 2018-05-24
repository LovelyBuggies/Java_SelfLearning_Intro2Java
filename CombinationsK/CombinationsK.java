
/******************************************************************************
 *  Compilation:  javac CombinationsK.java
 *  Execution:    java CombinationsK n k
 *  Author:       Nino Lau on 2017-08-14/17:12.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Enumerates all subsets of k on n elements using recursion.
 *  Uses some String library functions.
 *
 *  % java CombinationsK 5 3
 *  abc
 *  abd
 *  abe
 *  acd
 *  ace
 *  ade
 *  bcd
 *  bce
 *  bde
 *  cde
 *
 ******************************************************************************/

public class CombinationsK {

	public static void combK(String a, int choose) { combK("", a, choose); }

	// auxiliary function of comb
	private static void combK(String prefix, String a, int choose) {

		// get the length of string
		int n = a.length();

		// if no alternate part
		if (choose == 0) System.out.println(prefix);

		else {
			for (int i = 0; i < n; i++) {
				combK(prefix + a.charAt(i), a.substring(i + 1, n), choose - 1);
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int choose = Integer.parseInt(args[1]);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String elements = alphabet.substring(0, n);
        combK(elements, choose);
        System.out.println();
	}

}