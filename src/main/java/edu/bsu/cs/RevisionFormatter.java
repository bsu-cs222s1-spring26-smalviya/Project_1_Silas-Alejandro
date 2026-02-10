package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class RevisionFormatter {

    public List<String> format(List<Revision> revisions) {
        List<String> lines = new ArrayList<>();

        for (Revision revision : revisions) {
            lines.add(revision.getTimestamp() + "  " + revision.getUsername());
        }

        return lines;
    }
}
