package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
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
            Object json = JsonPath.parse(inputFile).json();
            List<Revision> revisions = RevisionParser.parse(json);

            Assertions.assertEquals("2026-01-30T23:10:39Z", revisions.get(0).getTimestamp());
            Assertions.assertEquals("TheCharlevoix", revisions.get(0).getUsername());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
