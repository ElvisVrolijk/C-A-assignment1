package com.company.assignment1;

import com.company.assignment1.algorithm.*;

/**
 * Complexity and Algorithms. Assignment 1, 2, 3.
 * Created by Elvis Vrolijk(e_voe_000) & Stanislav Dior(s1mpler) on 25/11/2017.
 */
class Assignment1 {

    ///////////////////////////////////////////////////////////////////////////
    //  Properties
    ///////////////////////////////////////////////////////////////////////////

    //Numbers
    static final int[] N1 = {5000, 10000, 20000, 50000, 100000, 200000};
    static final int[] N2 = {100000, 200000, 500000, 1000000, 5000000, 10000000};
    static final int[] N3 = {2000000, 5000000, 10000000, 20000000, 100000000};

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Runs algorithm.
     *
     * @return Average BigO as an integer.
     */
    int runAlgorithm(RunnableAlgorithm algorithm) throws AlgorithmException {
        if (!(algorithm instanceof BaseAlgorithm))
            throw new AlgorithmException("The algorithm class should be an instance of BaseAlgorithm: CustomAlgorithm extends BaseAlgorithm");

        return algorithm
                .run()
                .getAvgCounter();

    }
}