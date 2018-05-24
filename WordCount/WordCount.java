
/******************************************************************************
 *  Compilation:  javac WordCount.java 
 *  Execution:    java WordCount
 *  Author:       Nino Leo on 2018-08-11/10:47.
 *  Dependencies: StdIn.java StdOut.java
 *  Copyright © 2000-2011, Robert Sedgewick and Kevin Wayne.
 *
 *  Read in a sequence of strings from standard input and print out
 *  the number of strings read in.
 *
 *  % java WordCount
 *  it was the best of times
 *  it was the worst of times
 *  number of words  = 12
 *  Ctrl-d
 *
 *  % java WordCount < in.txt 
 *  using data of war and peace.
 *
 ******************************************************************************/

public class WordCount {

    public static void main(String[] args) {

        int count = 0;    
        
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;
        }
      
        // output
        StdOut.println("number of words  = " + count);
    }
}

