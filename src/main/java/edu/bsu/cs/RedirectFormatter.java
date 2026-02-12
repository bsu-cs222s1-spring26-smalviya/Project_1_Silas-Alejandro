package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class RedirectFormatter {

    public static List<String> format(List<Redirect> redirects) {
        List<String> lines = new ArrayList<>();

        for (Redirect redirect : redirects) {
            lines.add("from: " + redirect.getFrom() + ", to: " + redirect.getTo());
        }

        return lines;
    }

    public static String formatAsString(List<Redirect> redirects) {
        String string = "";

        for (Redirect redirect : redirects) {
            string += "Redirected to " + redirect.getTo() + "\n";
        }

        return string;
    }

}
