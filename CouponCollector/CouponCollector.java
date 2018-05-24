
/******************************************************************************
 *  Compilation:  javac CouponCollector.java
 *  Execution:    java CouponCollector n
 *  Author:       Nino Leo on 2017-08-10/11:31.
 *  Copyright © 2000-2011, Robert Sedgewick and kevin Wayne.
 *
 *  Given n distinct card types, how many random cards do you need
 *  do collect before you have (at least) one of each type?
 *  This program simulates this classical coupon collection problem.
 *
 *
 *  % java CouponCollector 1000
 *  6583
 *
 *  % java CouponCollector 1000
 *  6477
 *
 *  % java CouponCollector 1000000
 *  12782673
 *
 ******************************************************************************/

public class CouponCollector {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);     // number of card types
		boolean[] collected = new boolean[n];    // whether types are collected
		int count = 0;                         // total collections
		int distinct = 0;					   // number of distinct cards

		// repeatly choose a random card and check whether it's new
		while (distinct < n) {
			int value = (int) (Math.random() * n);  // random card between 0 and n-1
			count++;                                // collect one more card
			if (!collected[value]) {
				distinct++;
				collected[value] = true;
			}
		}

		// print the total number of cards collected
		System.out.println(count);
	}

}