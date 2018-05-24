
/******************************************************************************
 *  Compilation:  javac Deck.java
 *  Execution:    java Deck
 *  Author:       Nino Leo on 2017-08-04/11:02.
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Deal 52 cards uniformly at random.
 *
 *  % java Deck
 *  Ace of Clubs
 *  8 of Diamonds
 *  5 of Diamonds
 *  ...
 *  8 of Hearts
 *
 ******************************************************************************/

public class Deck {

	public static void main(String[] args) {

		String[] SUITS = {
			"Clubs", "Diamonds", "Hearts", "Spades"
		};
		String[] RANKS = {
			"2", "3", "4", "5", "6", "7", "8", 
			"9", "Jack", "Queen", "King", "Ace"
		};

		// initialize deck
		int n = SUITS.length * RANKS.length;
		String[] deck = new String[n];
		for(int i = 0; i < RANKS.length; ++i)
			for(int j = 0; j < SUITS.length; ++j)
				deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];

		// shuffle
		for(int i = 0; i < n; ++i) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		// print shuffled deck
        for (int i = 0; i < n; i++) {
            System.out.println(deck[i]);
        }

	}

}