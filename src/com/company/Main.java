package com.company;

import com.company.assignment.Assignment1;

import java.util.Scanner;

public class Main {

    private Assignment1 assignment1 = new Assignment1();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        welcomeText();
        while (true) {
            System.out.println("Please enter a number.\n");
            int response = scanner.nextInt();
            int amountResponse;
            if (response == 5) {
                break;
            } else {
                switch (response) {
                    case 1:
                        amountQuestion();
                        amountResponse = scanner.nextInt();
                        if (amountResponse > 5) {
                            if (warning(amountResponse)) {
                                makeAlgorithm1(amountResponse);
                            }
                        }
                        break;
                    case 2:
                        amountQuestion();
                        amountResponse = scanner.nextInt();
                        if (amountResponse > 5) {
                            if (warning(amountResponse)) {
                                makeAlgorithm2(amountResponse);
                            }
                        }
                        break;
                    case 3:
                        amountQuestion();
                        amountResponse = scanner.nextInt();
                        if (amountResponse > 5) {
                            if (warning(amountResponse)) {
                                makeAlgorithm3(amountResponse);
                            }
                        }
                        break;
                    case 4:
                        checkProbability();
                        break;
                    default:
                        System.out.println("Enter a valid number!");
                        break;
                }
            }
        }

    }

    public void makeAlgorithm1(int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            System.out.println("Loop nr: " + (i + 1) + "\n");
            assignment1.algorithm1();
        }
    }

    public void makeAlgorithm2(int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            System.out.println("Loop nr: " + (i + 1) + "\n");
            assignment1.algorithm2();
        }
    }

    public void makeAlgorithm3(int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            System.out.println("Loop nr: " + (i + 1) + "\n");
            assignment1.algorithm3();
        }
    }

    public void checkProbability() {
        assignment1.algoForProbability();
        assignment1.calculateProbability();
    }

    private void welcomeText() {
        System.out.println("Welcome to C&A assignment 1. \n" +
                "Enter 1 to see results of algorithm 1. \n" +
                "Enter 2 to see results of algorithm 2. \n" +
                "Enter 3 to see results of algorithm 3. \n" +
                "Enter 4 to see result of probability \n" +
                "If you want to exit the program just enter 5\n");
    }

    private void amountQuestion() {
        System.out.println("How many times you want to see the results? \n" +
                "Please enter a number");
    }

    private boolean warning(int times) {
        boolean answerIs;
        System.out.println("Warning!" +
                "It will take a while to see the results " + times + " times\n" +
                "do you want to continue? (y/n)\n");

        String response = scanner.next();

        switch (response.toLowerCase().replace(" ", "")) {
            case "y":
                answerIs = true;
                break;
            case "n":
                answerIs = false;
                break;
            default:
                System.out.println("We will take that as a no.");
                answerIs = false;
                break;

        }
        return answerIs;
    }
}

