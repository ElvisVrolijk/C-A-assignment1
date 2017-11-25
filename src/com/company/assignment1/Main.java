package com.company.assignment1;

/**
 * Endpoint class.
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
                case 1:
                    assignment1.startAlgorithm1();
                    break;
                case 2:
                    assignment1.startAlgorithm2();
                    break;
                case 3:
                    assignment1.startAlgorithm3();
                    break;
                case 4:
                    if (assignment1.isFastMode()) {
                        assignment1.setFastMode(false);
                    } else {
                        int factor = client.askInt("Decrease factor:");
                        assignment1
                                .setFactor(factor)
                                .setFastMode(true);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter a valid number!");
                    break;
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Welcome text procedure
     */
    private String menu() {
        String changeToMode;
        if (assignment1.isFastMode())
            changeToMode = "normal";
        else
            changeToMode = "fast";

        return "Welcome to C&A assignment1 1. \n" +
                "1 - algorithm 1\n" +
                "2 - algorithm 2\n" +
                "3 - algorithm 3\n" +
                "4 - change to " + changeToMode + " mode\n" +
                "5 - exit\n";
    }
}

