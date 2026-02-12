package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class RevisionParserTest {

    @Test
    public void parsesRevisionsFromSample() {
        File file = new File("src/test/resources/Sample.json");

        try {
            FileInputStream inputFile = new FileInputStream(file);
            List<Revision> revisions = RevisionParser.parse(inputFile);
            List<String> stringList = RevisionFormatter.format(revisions);
            Assertions.assertEquals("[2026-01-30T23:10:39Z  TheCharlevoix" +
                    ", 2026-01-30T23:10:06Z  TheCharlevoix" +
                    ", 2026-01-30T06:42:30Z  InternetArchiveBot" +
                    ", 2026-01-27T19:43:08Z  Tbf62]",
                    stringList.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
