package com.company.assignment1.algorithm;

import com.company.assignment1.AlgorithmPrinter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Base abstract class for algorithms.
 * Created by s1mpler on 11/24/17.
 */
public abstract class BaseAlgorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    AlgorithmPrinter printer = null;
    //array of amounts of data to process
    int[] n;
    //array of numbers from 0 to n[i]
    int[] array;
    int[] counter;
    int factor = 1;
    boolean fastMode = false;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    BaseAlgorithm(int[] n) {
        this.n = n;
    }

    BaseAlgorithm(int[] n, AlgorithmPrinter printer) {
        this.n = n;
        this.printer = printer;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

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
        Set<Integer> temp = new HashSet<>(array.length);
        for (int i : array) {
            if (temp.contains(i)) {
                return false;
            }
            temp.add(i);
        }
        return true;
    }

    /**
     * Sets the size to the array of numbers.
     *
     * @param size Size of the array to be set.
     */
    void addSizeToArray(int size) {
        array = new int[size];
    }

    /**
     * Generates a random number between i and j
     *
     * @param from The smallest possible number.
     * @param to The biggest possible number.
     * @return Random number.
     */
    int randomNumber(int from, int to) {
        if (to == 0) return 0;
        return new Random().nextInt(to - from) + from;
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

    /**
     * Divide all array elements by factor.
     * @param factor Value to divide.
     * @return Modified array.
     */
    private int[] decrease(int factor) {
        for (int i = 0; i < n.length; i++) {
            n[i] = n[i] / factor;
        }
        return n;
    }

    /**
     * Multiply all array elements by factor.
     * @param factor Value to multiply.
     * @return Modified array.
     */
    private int[] increase(int factor) {
        for (int i = 0; i < n.length; i++) {
            n[i] = n[i] * factor;
        }
        return n;
    }

    public BaseAlgorithm setFastMode(boolean fastMode) {
        if (fastMode) {
            this.n = decrease(this.factor);
        } else if (this.fastMode) {
            this.n = increase(this.factor);
        }
        this.fastMode = fastMode;

        return this;
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
