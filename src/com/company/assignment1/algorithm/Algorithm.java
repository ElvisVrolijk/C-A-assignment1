package com.company.assignment;

/**
 * Base class
 * Created by s1mpler on 11/24/17.
 */
public abstract class Algorithm {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    private int[] n;

    public Algorithm(int[] n) {
        this.n = n;
    }

    public void run() {

    }

    public int[] getNumbers() {
        return n;
    }

    public void setNumbers(int[] n) {
        this.n = n;
    }
}
