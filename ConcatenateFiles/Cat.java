/******************************************************************************
 *  Compilation:  javac Cat.java
 *  Execution:    java Cat file1.txt file2.txt file3.txt output.txt
 *  Author:       Nino Lau on 2017-08-14/11:40.
 *  Dependencies: In.java
 *
 *  Reads in text files specified as the first command-line 
 *  parameters, concatenates them, and writes the result to
 *  filename specified as the last command line parameter.
 *
 *
 ******************************************************************************/

public class Cat { 

    public static void main(String[] args) { 
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }

}