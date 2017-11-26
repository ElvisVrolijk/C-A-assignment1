package com.company.assignment1;

import java.util.Scanner;

/**
 * Helper class to communicate with a user.
 * Created by s1mpler on 11/25/17.
 */
class ClientInput {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    private Scanner scanner = new Scanner(System.in);

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Simply writes the text in console.
     * @param text Text to write.
     */
    public void tell(String text) {
        System.out.println(text);
    }

    /**
     * Writes the text in console with a border.
     * @param text Text to write.
     */
    public void tellImportant(String text) {
        System.out.println("----------- " + text + " -----------");
    }

    /**
     * Writes 3 new lines in console.
     */
    public void whiteSpace() {
        System.out.println("\n\n\n");
    }

    /**
     * Writes the question in console and waits for string response.
     * @param question Question to ask.
     * @return User input (answer) as a string.
     */
    public String askString(String question) {
        System.out.print(question + " ");
        return scanner.nextLine();
    }

    /**
     * Writes the question in console and waits for integer response.
     * @param question Question to ask.
     * @return User input (answer) as an integer.
     */
    public int askInt(String question) {
        System.out.print(question + " ");
        return scanner.nextInt();
    }
}
