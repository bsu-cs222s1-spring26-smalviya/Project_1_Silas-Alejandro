package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class RevisionFormatter {

    public static List<String> format(List<Revision> revisions) {
        List<String> lines = new ArrayList<>();

        for (Revision revision : revisions) {
            lines.add(revision.getTimestamp() + "  " + revision.getUsername());
        }

        return lines;
    }

    public static String formatAsString(List<Revision> revisions) {
        String string = "";

        int lineCount = 1;
        for (Revision revision : revisions) {
            string += lineCount + ")  " + revision.getTimestamp() + "  " + revision.getUsername() + "\n";
            lineCount++;
        }

        return string;
    }

}
