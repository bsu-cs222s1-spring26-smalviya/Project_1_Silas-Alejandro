package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WikipediaManager {

    public static void main(String[] args) {
        new WikipediaManager();
    }

    public WikipediaManager() {
        String input = ConsoleIO.getInput();
        if (input.isEmpty()) {
            System.err.println("No input provided...");
            return;
        }

        InputStream connection = null;
        try {
            connection = WikipediaConnection.connectToWikipedia(input, 15);
        } catch (IOException e) {
            System.err.println("Error connecting to network...");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object json = JsonPath.parse(connection).json();
        List<Object> jsonMissingStatus =
                JsonPath.read(json, "$.query.pages.*.missing");
        if (!jsonMissingStatus.isEmpty()) {
            System.err.println("Missing wikipedia article...");
            return;
        }

        List<Redirect> redirects = RedirectParser.parse(json);
        List<Revision> revisions = RevisionParser.parse(json);

        ConsoleIO.printOutput(redirects, revisions);

    }

    public static String searchForRevisions(String query) {
        if (query.isEmpty()) {
            return "No input provided...";
        }

        InputStream connection = null;
        try {
            connection = WikipediaConnection.connectToWikipedia(query, 15);
        } catch (IOException e) {
            return "Error connecting to network...";
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object json = JsonPath.parse(connection).json();
        List<Object> jsonMissingStatus =
                JsonPath.read(json, "$.query.pages.*.missing");
        if (!jsonMissingStatus.isEmpty()) {
            return "Missing wikipedia article...";
        }

        List<Redirect> redirects = RedirectParser.parse(json);
        List<Revision> revisions = RevisionParser.parse(json);

        String output = "";

        output += RedirectFormatter.formatAsString(redirects);
        output += RevisionFormatter.formatAsString(revisions);

        return output;
    }

}