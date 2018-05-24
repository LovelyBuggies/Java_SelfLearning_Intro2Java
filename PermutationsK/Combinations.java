
/******************************************************************************
 *  Compilation:  javac Combinations.java
 *  Execution:    java Combinations n
 *  
 *  Enumerates all subsets of n elements using recursion.
 *  Uses some String library functions.
 *
 *  % java Combinations 3
 *  
 *  a
 *  ab
 *  abc
 *  ac
 *  b
 *  bc
 *  c
 *
 *  Remark: this is, perhaps, easier by counting from 0 to 2^N - 1 by 1
 *  and looking at the bit representation of the counter. However, this
 *  recursive approach generalizes easily, e.g., if you want to print
 *  out all combinations of size k.
 *
 ******************************************************************************/

public class Combinations {

	public static void comb(String a) { comb("", a); }

	// auxiliary function of comb
	private static void comb(String prefix, String a) {

		// get the length of string
		int n = a.length();

		// if no alternate part
		if (n == 0) System.out.println(prefix);

		else {
			for (int i = 0; i < n; i++) {
				comb(prefix + a.charAt(i), a.substring(i + 1, n));
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        comb(elements);
        System.out.println();
	}

}