package com.company.assignment1;

import com.company.assignment1.algorithm.Algorithm1;
import com.company.assignment1.algorithm.Algorithm2;
import com.company.assignment1.algorithm.Algorithm3;

import java.util.*;

/**
 * Complexity and Algorithms. Assignment 1, 2, 3.
 * Created by e_voe_000 & s1mpler on 11/17/2016.
 */
class Assignment1 {

    ///////////////////////////////////////////////////////////////////////////
    //  Properties
    ///////////////////////////////////////////////////////////////////////////

    //Mode
    private boolean fastMode = false;
    private int factor = 1;

    //Numbers
    private int[] N1 = {5000, 10000, 20000, 50000, 100000, 200000};
    private int[] N2 = {100000, 200000, 500000, 1000000, 5000000, 10000000};
    private int[] N3 = {2000000, 5000000, 10000000, 20000000, 100000000};

    //Algorithms
    private Algorithm1 algorithm1;
    private Algorithm2 algorithm2;
    private Algorithm3 algorithm3;

    //printer
    private AlgorithmPrinter printer;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    Assignment1() {
        printer = new AlgorithmPrinter();

        this.algorithm1 = new Algorithm1(N1, printer);
        this.algorithm2 = new Algorithm2(N2, printer);
        this.algorithm3 = new Algorithm3(N3, printer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    void startAlgorithm1() {
        this.algorithm1.run();
    }

    void startAlgorithm2() {
        this.algorithm2.run();
    }

    void startAlgorithm3() {
        this.algorithm3.run();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Divide all array elements by factor.
     * @param array Array to mutate.
     * @param factor Value to divide.
     * @return Modified array.
     */
    private int[] decrease(int[] array, int factor) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] / factor;
        }
        return array;
    }

    /**
     * Multiply all array elements by factor.
     * @param array Array to mutate.
     * @param factor Value to multiply.
     * @return Modified array.
     */
    private int[] increase(int[] array, int factor) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * factor;
        }
        return array;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Setters
    ///////////////////////////////////////////////////////////////////////////

    public void setAlgorithm1(Algorithm1 algorithm1) {
        this.algorithm1 = algorithm1;
    }

    public void setAlgorithm2(Algorithm2 algorithm2) {
        this.algorithm2 = algorithm2;
    }

    public void setAlgorithm3(Algorithm3 algorithm3) {
        this.algorithm3 = algorithm3;
    }

    public Assignment1 setFactor(int factor) {
        if (factor > 1)
            this.factor = factor;
        return this;
    }

    public Assignment1 setFastMode(boolean fastMode) {
        if (fastMode) {
            N1 = decrease(N1, this.factor);
            N2 = decrease(N2, this.factor);
            N3 = decrease(N3, this.factor);
        } else if (this.fastMode) {
            N1 = increase(N1, this.factor);
            N2 = increase(N2, this.factor);
            N3 = increase(N3, this.factor);
        }

        this.algorithm1 = new Algorithm1(N1, printer);
        this.algorithm2 = new Algorithm2(N2, printer);
        this.algorithm3 = new Algorithm3(N3, printer);

        this.fastMode = fastMode;

        return this;
    }

    public int getFactor() {
        return factor;
    }

    public boolean isFastMode() {
        return fastMode;
    }
}
