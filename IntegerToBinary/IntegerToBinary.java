
/******************************************************************************
 *  Compilation:  javac IntegerToBinary.java
 *  Execution:    java IntegerToBinary n
 *  Author:       Nino Lau on 2017-08-14/11:16.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *  
 *  Prints out the binary representation of the integer n.
 *
 *  % java IntegerToBinary 8
 *  1000
 *
 *  % java IntegerToBinary 366
 *  101101110
 *
 ******************************************************************************/

public class IntegerToBinary {

	public static void convert(int n) {
		if (n == 0) return ;              // tailing digit print nothing if 0
		convert(n / 2);
		System.out.print(n % 2);          // predecessor digit print mod 2 digit
	}
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        convert(n);
        System.out.println();
    }

}