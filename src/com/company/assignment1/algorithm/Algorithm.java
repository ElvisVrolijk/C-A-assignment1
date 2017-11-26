package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Base abstract class for algorithms.
 * Created by s1mpler on 11/24/17.
 */
abstract class Algorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    AlgorithmPrinter printer;
    int[] n;
    int[] array;
    boolean[] used;
    int[] counter;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    Algorithm(int[] n) {
        this.n = n;
    }

    Algorithm(int[] n, AlgorithmPrinter printer) {
        this.n = n;
        this.printer = printer;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * All magic should happen here.
     * @return null.
     */
    Algorithm run() {
        return null;
    }

    /**
     * Calculates BigO by using amount of data and
     * amount of times this data has been proceeded.
     * @param counter Amount of times the data has been proceed.
     * @param amount Amount of data.
     * @return BigO value as double (type).
     */
    double bigO(int counter, int amount) {
        return counter / amount;
    }

    /**
     * Checks if the array is a legal permutation.
     *
     * @param array Array to be checked.
     * @return True if the array is a legal permutation.
     */
    boolean isLegalPermutation(int[] array) {
        Set<Integer> temp = new HashSet<>();
        for (int i : array) {
            if (temp.contains(i)) {
                return false;
            }
            temp.add(i);
        }
        return true;
    }

    /**
     * Sets the size to the array of numbers and used boolean array.
     *
     * @param size Size of the array to be set.
     */
    void addSizeToArray(int size) {
        array = new int[size];
        used = new boolean[size];
    }

    /**
     * Generates a random number between i and j
     *
     * @param i The smallest possible number.
     * @param j The biggest possible number.
     * @return Random number.
     */
    int randomNumber(int i, int j) {
        if (j == 0) return 0;
        return new Random().nextInt(j - i) + i;
    }

    /**
     * Calculates the average BigO.
     * @return Average BigO as an integer.
     */
    public int getAvgCounter() {
        int sum = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += bigO(counter[i], n[i]);
        }
        return sum / counter.length;
    }

    /**
     * Resets the counter
     */
    void resetCounter() {
        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters
    ///////////////////////////////////////////////////////////////////////////

    public int[] getCounter() {
        return counter;
    }

    public int[] getNumbers() {
        return n;
    }

    public void setNumbers(int[] n) {
        this.n = n;
    }

    public void setPrinter(AlgorithmPrinter printer) {
        this.printer = printer;
    }
}
