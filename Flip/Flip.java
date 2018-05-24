
/******************************************************************************
 *  Compilation:  javac Flip.java
 *  Execution:    java Flip
 *  Author:       Nino Leo on 2017-08-03/17:14.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Simulate a fair coin flip and print out "Heads" or "Tails" accordingly.
 *
 *  % java Flip
 *  Heads
 *
 *  % java Flip
 *  Heads
 *
 *  % java Flip
 *  Tails
 *
 ******************************************************************************/

public class Flip {

	public static void main(String[] args) {

		// Math.random() returns a value between 0.0 1.0.
		if(Math.random() < 0.5)
			System.out.println("Head.");
		else
			System.out.println("Tail.");
	}

}