
/******************************************************************************
 *  Compilation:  javac DivideByZero.java
 *  Execution:    java DivideByZero
 *  Author:       Nino Leo on 2016-08-03/15:45.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Demonstrates what happens when you divide by zero with integers
 *  and doubles.
 * 
 *  % java DivideByZero
 *  16.0 / 0.0 = Infinity
 *  16.0 % 0.0 = NaN
 *  Exception in thread "main" java.lang.ArithmeticException: / by zero
 *
 *
 ******************************************************************************/

public class DivideByZero {

    public static void main(String[] args) {

    	// infinity
        System.out.println("16.0 / 0.0 = " + (16.0 / 0.0));
        // not a number
        System.out.println("16.0 % 0.0 = " + (16.0 % 0.0));
        // ERROR
        System.out.println("16 / 0 = " + (16 / 0));
        // ERROR          
        System.out.println("16 % 0 = " + (16 % 0));
    }
    
}