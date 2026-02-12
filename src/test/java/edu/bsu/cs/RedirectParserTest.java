package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class RedirectParserTest {

    @Test
    public void parsesRedirectsFromSample() {
        File file = new File("src/test/resources/Sample.json");

        try {
            FileInputStream inputFile = new FileInputStream(file);
            List<Redirect> redirects = RedirectParser.parse(inputFile);
            String string = RedirectFormatter.formatAsString(redirects);
            Assertions.assertEquals("from: Zappa, to: Frank Zappa\n", string);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
