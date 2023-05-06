package me.noitcereon.consoleui;

import java.util.Scanner;

public class InputTaker {
    private InputTaker(){
        // Prevent instatiation.
    }
    public static String getInput(Scanner scanner){
        System.out.print("Enter input: ");
        return scanner.nextLine();
    }
}
