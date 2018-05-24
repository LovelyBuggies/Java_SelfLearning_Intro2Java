
/******************************************************************************
 *  Compilation:  javac UseArgs.java
 *  Execution:    java UseArgs actor1 actor2
 *  Author:       Nino Leo on 2017-08-03/15:00.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Prints basic conversation where actors' names are replaced by the
 *  command-line arguments.
 *
 *  % java UseArgument Bob Sara
 *  Hi, Bob. How are you?
 *  I'm fine and what about you, Sara?
 *
 ******************************************************************************/

public class UseArgs {

	public static void main(String[] args) {
		System.out.println("Hi," + args[0] + ". How are you?");
		System.out.println("I'm fine and what about you, " + args[1] + "?");
	}

}