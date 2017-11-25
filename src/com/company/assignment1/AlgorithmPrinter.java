package com.company.assignment1;

/**
 * Algorithm console printer.
 * Created by s1mpler on 11/25/17.
 */
public class AlgorithmPrinter {

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    public AlgorithmPrinter header(String text) {
        System.out.println("=================================");
        System.out.println(text);
        System.out.println("=================================");
        return this;
    }

    public AlgorithmPrinter title(String text) {
        System.out.print("\t" + text);
        return this;
    }

    public AlgorithmPrinter line(String text) {
        System.out.print("\t\t" + text);
        return this;
    }

    public AlgorithmPrinter br() {
        System.out.print("\n");
        return this;
    }

    public AlgorithmPrinter whiteSpace() {
        System.out.println("\n\n\n");
        return this;
    }

    // TODO: 11/25/17 add log n^2 n^3 etc.
    public String stringBigO(String text) {
        return "O(" + text + ")";
    }
}
