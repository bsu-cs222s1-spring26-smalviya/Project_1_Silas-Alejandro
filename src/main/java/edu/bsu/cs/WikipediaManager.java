package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class WikipediaManager {

    public static void main(String[] args) {
        new WikipediaManager();
    }

    public WikipediaManager() {
        String input = ConsoleIO.getInput();
        if (input.isEmpty()) {
            System.err.println("No input provided...");
        }

    }

}
