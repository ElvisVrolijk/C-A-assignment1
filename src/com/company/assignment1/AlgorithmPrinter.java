package com.company.assignment1;

/**
 * Algorithm console printer.
 * Created by s1mpler on 11/25/17.
 */
public class AlgorithmPrinter {

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Writes text in console with a border.
     * @param text Text to write.
     * @return This object.
     */
    public AlgorithmPrinter header(String text) {
        System.out.println("=================================");
        System.out.println(text);
        System.out.println("=================================");
        return this;
    }

    /**
     * Writes text in console with a tabulation.
     * @param text Text to write.
     * @return This object.
     */
    public AlgorithmPrinter title(String text) {
        System.out.print("\t" + text);
        return this;
    }

    /**
     * Writes text in console with two tabulations.
     * @param text Text to write.
     * @return This object.
     */
    public AlgorithmPrinter line(String text) {
        System.out.print("\t\t" + text);
        return this;
    }

    /**
     * Writes new line in console.
     * @return This object.
     */
    public AlgorithmPrinter br() {
        System.out.print("\n");
        return this;
    }

    /**
     * Writes 3 new lines in console.
     * @return This object.
     */
    public AlgorithmPrinter whiteSpace() {
        System.out.println("\n\n\n");
        return this;
    }

    /**
     * Writes BigO expression in console.
     * @param value BigO value.
     * @return BigO formatted string.
     */
    public String stringBigO(double value) {
        return "O(" + value + "n)";
    }
}
