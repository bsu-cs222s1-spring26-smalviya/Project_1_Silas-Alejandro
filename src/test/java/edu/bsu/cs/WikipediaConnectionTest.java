package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WikipediaConnectionTest {
    @Test
    void connectsToWikipediaForValidTitle() throws Exception {
        WikipediaConnection connect = new WikipediaConnection();

        URLConnection connection = connect.connectToWikipedia("Zappa", 1);

        assertNotNull(connection);
    }


}
