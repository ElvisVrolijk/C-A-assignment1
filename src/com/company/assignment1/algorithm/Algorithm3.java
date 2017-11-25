package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

/**
 * Algorithm 3.
 * Created by s1mpler on 11/25/17.
 */
public class Algorithm3 extends Algorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Algorithm3(int[] n) {
        super(n);
    }

    public Algorithm3(int[] n, AlgorithmPrinter printer) {
        super(n, printer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * The method where all magic happens.
     */
    @Override
    public void run() {
        if (printer != null)
            printer.header(this.toString());

        for (int amount : n) {
            addSizeToArray(amount);

            for (int i = 0; i < amount; i++) {
                array[i] = i;
                swap(array[i], array[randomNumber(0, i)]);
            }

            if(printer != null) {
                //print the result after each iteration
                printer
                        .title("Size :" + amount)
                        .br()
                        .line("Legal permutation :" + isLegalPermutation(array))
                        .br()
                        .line("BigO :" + printer.stringBigO(String.valueOf(bigO())))
                        .whiteSpace();
            }
        }
    }

    @Override
    public String toString() {
        return "Algorithm 3";
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Switches the position of position 1 and 2
     *
     * @param position1 Position of element 1.
     * @param position2 Position of element 2.
     */
    private void swap(int position1, int position2) {
        int temporaryContainer = array[position1];
        array[position1] = array[position2];
        array[position2] = temporaryContainer;
    }
}
