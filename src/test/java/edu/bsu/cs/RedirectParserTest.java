package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
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
            Object json = JsonPath.parse(inputFile).json();
            List<Redirect> redirects = RedirectParser.parse(json);

            Assertions.assertEquals("Zappa", redirects.get(0).getFrom());
            Assertions.assertEquals("Frank Zappa", redirects.get(0).getTo());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
