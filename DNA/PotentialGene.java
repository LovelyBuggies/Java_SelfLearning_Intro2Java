
/******************************************************************************
 *  Compilation:  javac PotentialGene.java
 *  Execution:    java PotentialGene < input.txt
 *  Author:       Nino Lau on 2017-08-15/09:56.
 *  Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
 *
 *  Determines whether a a DNA string corresponds to a potential gene
 *      - length is a multiple of 3
 *      - starts with the start codon (ATG)
 *      - ends with a stop codon (TAA or TAG or TGA)
 *      - has no intervening stop codons
 *
 *  % java PotentialGene ATGCGCCTGCGTCTGTACTAG
 *  true
 *
 *  % java PotentialGene ATGCGCTGCGTCTGTACTAG
 *  false
 *
 ******************************************************************************/

public class PotentialGene {

    public static boolean isPotentialGene(String DNA) {
    	String startCodon = "ATG";
    	String[] endCodons = {"TAA", "TAG", "TGA"};

        // Length is a multiple of 3.
        if (DNA.length() % 3 != 0) return false;

        // Starts with start codon.
        if (!DNA.startsWith(startCodon)) return false;

        // No intervening stop codons.
        for (int i = 0; i < 3; i++) {
        	String prefix = DNA.substring(0, DNA.length() - 3);
        	if (prefix.contains(endCodons[i])) return false;
        }

        // Ends with a stop codon.
        for (int i = 0; i < 3; i++) {
        	if (DNA.endsWith(endCodons[i])) return true;
        }
 	 	return false;
    }

    public static void main(String[] args) {
        String DNA = args[0];
        System.out.println(isPotentialGene(DNA));
    }
}