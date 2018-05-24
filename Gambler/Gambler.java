
/******************************************************************************
 *  Compilation:  javac Gambler.java
 *  Execution:    java Gambler stake goal N
 *  Author:       Nino Leo on 2017-08-04/07:34.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Simulates a gambler who start with $stake and place fair $1 bets
 *  until she goes broke or reach $goal. Keeps track of the number of
 *  times she wins and the number of bets she makes. Run the experiment N
 *  times, averages the results, and prints them out.
 *
 *  % java Gambler 50 250 1000
 *  178 wins of 1000
 *  Percent of games won = 17.8
 *  Avg # bets           = 10010.79
 *
 *  % java Gambler 50 150 1000
 *  337 wins of 1000
 *  Percent of games won = 33.7
 *  Avg # bets           = 4863.95
 * 
 *  % java Gambler 50 100 1000
 *  503 wins of 1000
 *  Percent of games won = 50.3
 *  Avg # bets           = 2464.59
 *
 ******************************************************************************/

public class Gambler {

	public static void main(String[] args) {

		int stake = Integer.parseInt(args[0]);		// gamble's staking bankroll
		int goal = Integer.parseInt(args[1]);		// gamble's desiring bankroll
		int trials = Integer.parseInt(args[2]);		// number of trials to perform

		int bets = 0;								// total number of bets made
		int wins = 0;								// total number of games won

		// repeat trials times
		for(int t = 0; t < trials; t++) {

			// do one gambler's ruin simulation
			int cash = stake;
			while (cash > 0 && cash < goal) {
				bets++;
				if (Math.random() < 0.5) cash++;
				else cash--;
			}
			if(cash == goal) wins++;
		}

        // print results
        System.out.println(wins + " wins of " + trials);
        System.out.println("Percent of games won = " + 100.0 * wins / trials);
        System.out.println("Avg # bets           = " + 1.0 * bets / trials);
	}

}