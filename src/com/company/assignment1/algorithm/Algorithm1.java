package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

/**
 * Algorithm 1.
 * Created by s1mpler on 11/25/17.
 */
public class Algorithm1 extends BaseAlgorithm implements RunnableAlgorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Algorithm1(int[] n) {
        super(n);
        this.counter = new int[n.length];
    }

    public Algorithm1(int[] n, AlgorithmPrinter printer) {
        super(n, printer);
        this.counter = new int[n.length];
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * All magic happens here.
     */
    @Override
    public Algorithm1 run() {
        if (printer != null)
            printer.header(this.toString());

        resetCounter();
        int randomNumber;

        //loop through amounts of data to proceed
        for (int i = 0; i < n.length; i++) {
            int amount = n[i];
            addSizeToArray(amount);

            //set all array elements to -1 (so they are not contributing to permutation)
            for (int j = 0; j < amount; j++) {
                array[j] = -1;
            }

            final long start = System.nanoTime();

            //proceed the amount of data
            for (int j = 0; j < amount; j++) {
                //pick random number until it is not in the array
                do {
                    randomNumber = randomNumber(0, amount);
                    counter[i]++;
                } while (isInArray(randomNumber, j));

                //set value
                array[j] = randomNumber;
                counter[i]++;
            }

            final long end = System.nanoTime();

            if(printer != null) {
                //print the result after each iteration
                printer
                        .title("Size :" + amount)
                        .br()
                        .line("Legal permutation :" + isLegalPermutation(array))
                        .br()
                        .line("BigO :" + printer.stringBigO(bigO(counter[i], amount)))
                        .br()
                        .line("Time: " + ((end - start) / 1000000000) + " seconds or " + ((end - start) / 1000000) + " ms")
                        .br();
            }
        }
        return this;
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

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////

    public int[] getCounter() {
        return counter;
    }
}