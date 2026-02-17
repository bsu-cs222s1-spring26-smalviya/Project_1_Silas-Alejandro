package edu.bsu.cs;

import java.util.List;
import java.util.Scanner;

public class ConsoleIO {

    public static String getInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Query: ");
        String response = input.nextLine();
        return response;
    }
}