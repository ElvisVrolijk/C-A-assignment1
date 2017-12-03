package com.company.assignment1;

import com.company.assignment1.algorithm.*;

/**
 * Endpoint class.
 *
 * @author Elvis Vrolijk.
 * @author Stanislav Dior.
 *
 * @version 1.0.0.
 *
 * @copyright Saxion 2017. Complexity & Algorithms Assignment 1.
 */
public class Main {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    private Assignment1 assignment1 = new Assignment1();
    private ClientInput client = new ClientInput();
    private AlgorithmPrinter printer = new AlgorithmPrinter();

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * End point.
     * @param args Process environment arguments.
     */
    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (AlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the application.
     * @throws AlgorithmException Wrong algorithm type.
     */
    private void run() throws AlgorithmException {
        RunnableAlgorithm algorithm;
        while (true) {
            client.tell(menu());
            int menuChoice = client.askInt("Please enter a number:");
            int amountChoice;

            switch (menuChoice) {
                case 1: //algorithm 1
                    amountChoice = client.askInt("How many times do you want to run this algorithm?");
                    algorithm = new Algorithm1(Assignment1.N1, printer);
                    for (int i = 0; i < amountChoice; i++) {
                        client.tellImportant("Average BigO is " + assignment1.runAlgorithm(algorithm) + "n");
                        client.whiteSpace();
                    }
                    break;
                case 2: //algorithm 2
                    amountChoice = client.askInt("How many times do you want to run this algorithm?");
                    algorithm = new Algorithm2(Assignment1.N2, printer);
                    for (int i = 0; i < amountChoice; i++) {
                        client.tellImportant("Average BigO is " + assignment1.runAlgorithm(algorithm) + "n");
                        client.whiteSpace();
                    }
                    break;
                case 3: //algorithm 3
                    amountChoice = client.askInt("How many times do you want to run this algorithm?");
                    algorithm = new Algorithm3(Assignment1.N3, printer);
                    for (int i = 0; i < amountChoice; i++) {
                        client.tellImportant("Average BigO is " + assignment1.runAlgorithm(algorithm) + "n");
                        client.whiteSpace();
                    }
                    break;
                case 4: //exit the program
                    return;
                default: //invalid input
                    System.out.println("Enter a valid number!");
                    break;
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Welcome text procedure.
     */
    private String menu() {
        return "Welcome to C&A assignment1\n" +
                "1 - algorithm 1\n" +
                "2 - algorithm 2\n" +
                "3 - algorithm 3\n" +
                "4 - exit\n";
    }
}

