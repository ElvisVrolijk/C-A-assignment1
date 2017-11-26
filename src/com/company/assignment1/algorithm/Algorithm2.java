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
        this.counter = new int[n.length];
    }

    public Algorithm2(int[] n, AlgorithmPrinter printer) {
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
    public Algorithm2 run() {
        if (printer != null)
            printer.header(this.toString());

        resetCounter();
        int randomNumber;

        //loop through amounts of data to proceed
        for (int i = 0; i < n.length; i++) {
            int amount = n[i];
            addSizeToArray(amount);

            //set all array and used elements to (-1 and false) (so they are not contributing to permutation)
            for (int j = 0; j < amount; j++) {
                array[j] = -1;
                used[j] = false;
            }

            //proceed the amount of data
            for (int j = 0; j < amount; j++) {
                do {
                    randomNumber = randomNumber(0, amount);
                    counter[i]++;
                } while (alreadyUsed(randomNumber));

                array[j] = randomNumber;
                used[randomNumber] = true;
                counter[i]++;
            }

            if(printer != null) {
                //print the result after each iteration
                printer
                        .title("Size :" + amount)
                        .br()
                        .line("Legal permutation :" + isLegalPermutation(array))
                        .br()
                        .line("BigO :" + printer.stringBigO(bigO(counter[i], amount)))
                        .br()
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

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////

    public int[] getCounter() {
        return counter;
    }
}
