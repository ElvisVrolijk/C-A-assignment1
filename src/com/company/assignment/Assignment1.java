package com.company.assignment;

import java.util.*;

/**
 * Created by e_voe_000 on 11/17/2016.
 */
public class Assignment1 {

    private List<int[]> list = new ArrayList<>();

    ///////////////////////////////////////////////////////////////////////////
    //  Array of N for each algorithm.
    ///////////////////////////////////////////////////////////////////////////
    private int[] n1 = {5000, 10000, 20000, 50000, 100000};

    private double counterAlgo1;

    private int[] n2 = {100000, 500000, 1000000, 5000000, 10000000};

    private int[] n3 = {5000000, 10000000, 20000000, 40000000, 80000000};

    private int[] array;

    private boolean[] used;

    private Random random = new Random();

    /**
     * Algorithm 1
     * uses the sizes in n1
     * expectation of BigO is n^3
     */
    public void algorithm1() {
        System.out.println("Algorithm 1");
        int rg;


        for (int i = 0; i < n1.length; i++) {
            counterAlgo1 = 0;
            addSizeToArray(n1[i]);

            for (int j = 0; j < n1[i]; j++) {
                array[j] = -1;
            }

            for (int j = 0; j < n1[i]; j++) {
                do {
                    rg = randInt(0, n1[i]);
                } while (isAlreadyInArray(rg, j));
                array[j] = rg;

            }

            System.out.println("Size of n: " + n1[i] + "\n" +
                    "Legal permutation: " + isLegalPermutation(array) + "\n" +
                    "BigO : O(" + counterAlgo1 + ")\n");
        }


    }

    /**
     * used in algorithm 1 to compare the numbers that we want to insert
     * with the ones that already in the array
     *
     * @param number
     * @param startPoint
     * @return true if number in already in the array
     */
    private boolean isAlreadyInArray(int number, int startPoint) {
        for (int i = startPoint + 1; i > 0; i--) {
            if (array[i - 1] == number) {
                return true;
            }
            counterAlgo1++;
        }
        return false;
    }

    /**
     * used in all algorithm to check if the array is a legal permutation
     *
     * @param array
     * @return true if the array is a permutation
     */
    private boolean isLegalPermutation(int[] array) {
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
     * Algorithm 2
     * uses sizes in n2
     * expectation of BigO is n^2
     */
    public void algorithm2() {
        System.out.println("Algorithm 2");
        int rg;
        int counter;

        for (int i = 0; i < n2.length; i++) {
            counter = 0;
            addSizeToArray(n2[i]);

            for (int j = 0; j < n2[i]; j++) {
                array[j] = -1;
                used[j] = false;
            }

            for (int j = 0; j < n2[i]; j++) {
                do {
                    rg = randInt(0, n2[i]);
                    counter++;
                } while (alreadyUsed(rg));
                array[j] = rg;
                used[rg] = true;
            }

            System.out.println("Size of n: " + n2[i] + "\n" +
                    "Legal permutation: " + isLegalPermutation(array) + "\n" +
                    "BigO : O(" + counter + ")\n");

        }
    }

    /**
     * used in algorithm 2 to see if the number is already used in the array
     *
     * @param number
     * @return true if the number is already used
     */
    private boolean alreadyUsed(int number) {
        return used[number];
    }

    /**
     * Algorithm 3
     * uses sizes in n3
     * expectation of BigO is n
     */
    public void algorithm3() {
        System.out.println("Algorithm 3");

        int counter;

        for (int i = 0; i < n3.length; i++) {
            counter = 0;
            addSizeToArray(n3[i]);

            for (int j = 0; j < n3[i]; j++) {
                array[j] = j;
                swap(array[j], array[randInt(0, j)]);
                counter++;
            }

            System.out.println("Size of n: " + n3[i] + "\n" +
                    "Legal permutation: " + isLegalPermutation(array) + "\n" +
                    "BigO : O(" + counter + ")\n");
        }
    }

    /**
     * switch the position of position 1 and 2
     *
     * @param position1
     * @param position2
     */
    private void swap(int position1, int position2) {
        int temporaryContainer = array[position1];
        array[position1] = array[position2];
        array[position2] = temporaryContainer;
    }

    /**
     * generate a random number between i and j
     *
     * @param i
     * @param j
     * @return random number
     */
    private int randInt(int i, int j) {
        if (j == 0) return 0;
        return random.nextInt(j - i) + i;
    }

    /**
     * set the size to the array and used boolean array
     *
     * @param size
     */
    private void addSizeToArray(int size) {
        array = new int[size];
        used = new boolean[size];
    }

    /**
     * this method is for adding array in a list
     * and used for probability method below
     */
    public void algoForProbability() {
        int rg;

        for (int i = 0; i < 1000; i++) {
            counterAlgo1 = 0;
            addSizeToArray(n1[0]);

            for (int j = 0; j < n1[0]; j++) {
                array[j] = -1;
            }

            for (int j = 0; j < n1[0]; j++) {
                do {
                    rg = randInt(0, n1[0]);
                } while (isAlreadyInArray(rg, j));
                array[j] = rg;
            }

            list.add(array);
        }
    }

    /**
     * this method is for calculating if 2 array are the same legal
     * permutation and calculate the probability of this
     */
    public void calculateProbability() {
        double counterForTrue = 0;
        double counterForFalse = 0;
        double arrayComparisons = 0;
        double numbersComparisons = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int[] a = list.get(i);
                int[] b = list.get(j);
                if (a.length == b.length) {
                    arrayComparisons++;
                    for (int k = 0; k < a.length; k++) {
                        numbersComparisons++;
                        if (a[k] == b[k]) {
                            counterForTrue++;
                        } else {
                            counterForFalse++;
                        }
                    }
                }
            }
        }

        System.out.println("true: " + counterForTrue);
        System.out.println("false: " + counterForFalse);
        System.out.println("Total Array comparisons:" + arrayComparisons);
        System.out.println("Total Number comparisons:" + numbersComparisons);
        double probability = counterForTrue / (counterForTrue + counterForFalse) * 100;
        System.out.println("probability: " + probability + "%");
    }


}
