
/******************************************************************************
 *  Compilation:  javac NameOfDay.java
 *  Execution:    java NameOfDay day
 *  Author:       Nino Leo on 2017-08-04/07:38.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Converts a day of the week (0 to 6) to the corresponding name (Sunday
 *  to Saturday).
 *
 *  % java NameOfDay 0
 *  Sunday
 *
 *  % java NameOfDay 2
 *  Tuesday
 *
 ******************************************************************************/

public class NameOfDay {

	public static void main(String[] args) {
		int day = Integer.parseInt(args[0]);
		switch(day) {
			case 0: System.out.println("Sunday"); break;
			case 1: System.out.println("Monday"); break;
			case 2: System.out.println("Tuesday"); break;
			case 3: System.out.println("Wednesday"); break;
			case 4: System.out.println("Thursday"); break;
			case 5: System.out.println("Friday"); break;
			case 6: System.out.println("Saturday"); break;
			default: System.out.println("Invalid"); break;
		}
	}

}