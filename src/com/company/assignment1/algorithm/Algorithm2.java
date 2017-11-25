package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

/**
 * Algorithm 2.
 * Created by s1mpler on 11/25/17.
 */
public class Algorithm2 extends Algorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Algorithm2(int[] n) {
        super(n);
    }

    public Algorithm2(int[] n, AlgorithmPrinter printer) {
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

        int randomNumber;

        for (int amount : n) {
            addSizeToArray(amount);

            for (int i = 0; i < amount; i++) {
                array[i] = -1;
                used[i] = false;
            }

            for (int i = 0; i < amount; i++) {
                do {
                    randomNumber = randomNumber(0, amount);
                } while (alreadyUsed(randomNumber));

                array[i] = randomNumber;
                used[randomNumber] = true;
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

    /**
     * @return The name of the algorithm.
     */
    @Override
    public String toString() {
        return "Algorithm 2";
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Checks if the number was already used.
     * @param number An element from the permutation list.
     * @return True if the element was already used. False otherwise.
     */
    private boolean alreadyUsed(int number) {
        return used[number];
    }
}
