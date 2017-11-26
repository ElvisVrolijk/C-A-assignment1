package com.company.assignment1;

/**
 * Endpoint class.
 *
 * @author Elvis Vrolijk.
 * @author Stanislav Dior.
 *
 * @version 1.0.0.
 *
 * @copyright Saxion 2017-2017. Complexity & Algorithms Assignment 1.
 */
public class Main {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    private Assignment1 assignment1 = new Assignment1();
    private ClientInput client = new ClientInput();

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * End point.
     * @param args Process environment arguments.
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Runs the application.
     */
    private void run() {
        while (true) {
            client.tell(menu());
            int menuChoice = client.askInt("Please enter a number:");

            switch (menuChoice) {
                case 1: //algorithm 1
                    client.tellImportant("Average BigO is " + assignment1.startAlgorithm1() + "n");
                    client.whiteSpace();
                    break;
                case 2: //algorithm 2
                    client.tellImportant("Average BigO is " + assignment1.startAlgorithm2() + "n");
                    client.whiteSpace();
                    break;
                case 3: //algorithm 3
                    client.tellImportant("Average BigO is " + assignment1.startAlgorithm3() + "n");
                    client.whiteSpace();
                    break;
                case 4: //toggle normal/fast mode
                    if (assignment1.isFastMode()) {
                        assignment1.setFastMode(false);
                    } else {
                        int factor = client.askInt("Decrease factor:");
                        assignment1
                                .setFactor(factor)
                                .setFastMode(true);
                    }
                    break;
                case 5: //exit the programm
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
        String changeToMode;
        if (assignment1.isFastMode())
            changeToMode = "normal";
        else
            changeToMode = "fast";

        return "Welcome to C&A assignment1\n" +
                "1 - algorithm 1\n" +
                "2 - algorithm 2\n" +
                "3 - algorithm 3\n" +
                "4 - change to " + changeToMode + " mode\n" +
                "5 - exit\n";
    }
}

