package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

/**
 * BaseAlgorithm 3.
 * Created by s1mpler on 11/25/17.
 */
public class Algorithm3 extends BaseAlgorithm implements RunnableAlgorithm{

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Algorithm3(int[] n) {
        super(n);
        this.counter = new int[n.length];
    }

    public Algorithm3(int[] n, AlgorithmPrinter printer) {
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
    public Algorithm3 run() {
        if (printer != null)
            printer.header(this.toString());

        resetCounter();

        //loop through amounts of data to proceed
        for (int i = 0; i < n.length; i++) {
            int amount = n[i];
            addSizeToArray(amount);

            final long start = System.nanoTime();

            //proceed the amount of data
            for (int j = 0; j < amount; j++) {
                array[j] = j;
                swap(array[j], array[randomNumber(0, j)]);
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
        return "BaseAlgorithm 3";
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

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////

    public int[] getCounter() {
        return counter;
    }
}
