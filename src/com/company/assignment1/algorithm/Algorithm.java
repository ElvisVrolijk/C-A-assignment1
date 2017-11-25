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

    void run() {}

    double bigO() {
        return 0.0;
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

    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters
    ///////////////////////////////////////////////////////////////////////////

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
