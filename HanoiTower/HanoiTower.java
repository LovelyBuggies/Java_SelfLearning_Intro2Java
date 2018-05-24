
/******************************************************************************
 *  Compilation:  javac HanoiTower.java
 *  Execution:    java HanoiTower n
 *  Author:       Nino Lau on 2017-08-14/10:28.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Solves the Towers of Hanoi problem on n discs. The discs are labeled
 *  in increasing order of size from 1 to n.
 * 
 *  %  java HanoiTower 3
 *
 *  Move No.1 from A to C
 *  Move No.2 from A to B
 *  Move No.1 from C to B
 *  Move No.3 from A to C
 *  Move No.1 from B to A
 *  Move No.2 from B to C
 *  Move No.1 from A to C
 *
 ******************************************************************************/

public class HanoiTower {

	public static void move(int level, char from, char inter, char to) {
		if(level == 1) System.out.println("Move No." + level + " from " + from + " to " + to.);
		else {
			move(level - 1, from, to, inter);
			System.out.println("Move No." + level + " from " + from + " to " + to.);
			move(level - 1, inter, from, to);
		}
	}

	public static void main(String[] args) {
		int nDisks = Integer.parseInt(args[0]);
		move(nDisks, 'A', 'B', 'C');
	}

}