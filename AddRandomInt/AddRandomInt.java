
/******************************************************************************
 *  Compilation:  javac AddRandomInt.java
 *  Execution:    java AddRandomInt 
 *  Author:       Nino Leo on 2017-08-03/15:26.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Generate 2 integers between 1 and 6, and print their sum.
 * 
 *  %  java AddRandomInt
 *  5
 *
 *  %  java AddRandomInt
 *  9
 *
 *  %  java AddRandomInt
 *  3
 *
 *  %  java AddRandomInt
 *  11
 *
 *  %  java AddRandomInt
 *  8
 *
 *  %  java AddRandomInt
 *  7
 *
 ******************************************************************************/

public class AddRandomInt {

	public static void main(String[] args) {

		// Generate two random integers.
		int ran1 = (int) (5 * Math.random()) + 1;
		int ran2 = (int) (5 * Math.random()) + 1;

		// Print their sum.
		System.out.println(ran1 + ran2);
	}
}