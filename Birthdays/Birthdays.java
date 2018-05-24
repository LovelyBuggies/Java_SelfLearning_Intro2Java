/******************************************************************************
 *  Compilation:  javac Birthdays.java
 *  Execution:    java Birthdays days trials
 *  Author:       Nino Leo o n 2017-08-10/17:21.
 *  Copyrights © 2000-2011, Rober Sedgewick and Kevin Wayne.
 *  
 *  Computes the number of people (by simulation) that must enter a room
 *  until two of them share a birthday. Assumes birthdays are uniform
 *  and independent from 0 to days-1. Repeats the experiment the specified
 *  number of times and print the average.
 *  prints the average
 *  
 *  % java Birthdays 365 100000
 *  Average = 24.65394
 *
 *  Remark: the expected number of people for days = 365 is about 24.61658.
 *  (The median number is about 23, but the average is higher.)
 *
 ******************************************************************************/


public class Birthdays { 

    public static void main(String[] args) { 
        int days   = Integer.parseInt(args[0]);    // number of days
        int trials = Integer.parseInt(args[1]);    // number of trials
        int people = 0;                            // total number of people over all trials

        // repeat trials times
        for (int t = 0; t < trials; t++) {

            //  hasBirthday[d] = true if someone born on day d; false otherwise
            boolean[] hasBirthday = new boolean[days];

            while (true) {
                people++;                               // one more person enters the room
                int d = (int) (days * Math.random());   // integer between 0 and days-1
                if (hasBirthday[d]) break;              // found two people with the same birthday
                hasBirthday[d] = true;                  // update array
            }
        }

        double average = (double) people / trials;
        System.out.println("Average = " + average);
    }
}
