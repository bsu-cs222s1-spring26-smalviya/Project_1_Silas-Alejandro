package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WikipediaConnectionTest {
    @Test
    void connectsToWikipediaForValidTitle() throws Exception {

        InputStream connection = WikipediaConnection.connectToWikipedia("Zappa", 1);

        assertNotNull(connection);
    }


}
