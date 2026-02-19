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

        Object json;
        try {
            json = getWikipediaRevisionsJson(input);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        List<Redirect> redirects = RedirectParser.parse(json);
        List<Revision> revisions = RevisionParser.parse(json);

        ConsoleIO.printOutput(redirects, revisions);

    }

    public static Object getWikipediaRevisionsJson(String query) throws Exception {
        InputStream connection = null;
        try {
            connection = WikipediaConnection.connectToWikipedia(query, 15);
        } catch (IOException e) {
            throw new Exception("Error connecting to network...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object json = JsonPath.parse(connection).json();
        List<Object> jsonMissingStatus =
                JsonPath.read(json, "$.query.pages.*.missing");
        if (!jsonMissingStatus.isEmpty()) {
            throw new Exception("Missing wikipedia article...");
        }

        return json;
    }

}