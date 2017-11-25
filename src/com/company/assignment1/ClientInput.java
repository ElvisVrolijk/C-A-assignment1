package com.company.assignment1;

import java.util.Scanner;

/**
 * Helper class to communicate with a user.
 * Created by s1mpler on 11/25/17.
 */
public class ClientInput {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////

    Scanner scanner = new Scanner(System.in);

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////
    public void tell(String text) {
        System.out.println(text);
    }

    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        System.out.print(question + " ");
        return scanner.nextInt();
    }
}
