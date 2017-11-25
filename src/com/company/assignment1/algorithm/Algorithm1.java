package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

/**
 * Algorithm 1.
 * Created by s1mpler on 11/25/17.
 */
public class Algorithm1 extends Algorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Algorithm1(int[] n) {
        super(n);
    }

    public Algorithm1(int[] n, AlgorithmPrinter printer) {
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

        //loop through amounts of data to proceed
        for (int amount : n) {
            addSizeToArray(amount);

            //set all array elements to -1 (so they are not contributing to permutation)
            for (int i = 0; i < amount; i++) {
                array[i] = -1;
            }

            //proceed the amount of data
            for (int i = 0; i < amount; i++) {
                //pick random number until it is not in the array
                do {
                    randomNumber = randomNumber(0, amount);
                } while (isInArray(randomNumber, i));

                //set value
                array[i] = randomNumber;
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
        return "Algorithm 1";
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Check if the number appears in the array.
     *
     * @param number Number to search.
     * @param startIndex Start point of searching.
     * @return True if number in already in the array, false otherwise.
     */
    private boolean isInArray(int number, int startIndex) {
        for (int i = startIndex + 1; i > 0; i--) {
            if (array[i - 1] == number) {
                return true;
            }
        }
        return false;
    }
}
