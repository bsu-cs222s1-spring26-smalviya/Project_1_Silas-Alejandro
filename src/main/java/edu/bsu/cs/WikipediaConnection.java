package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WikipediaConnection {

    public static InputStream connectToWikipedia(String title, int limit)
            throws IOException, URISyntaxException {

        String encodedTitle = URLEncoder.encode(title, Charset.defaultCharset());

        String urlString =
                "https://en.wikipedia.org/w/api.php" +
                        "?action=query" +
                        "&format=json" +
                        "&prop=revisions" +
                        "&titles=" + encodedTitle +
                        "&rvprop=timestamp%7Cuser" +
                        "&rvlimit=" + limit +
                        "&redirects";

        URI uri = new URI(urlString);
        URLConnection connection = uri.toURL().openConnection();
        connection.setRequestProperty("User-Agent",
                "FirstProject/0.1 (academic use; https://example.com)");
        return connection.getInputStream();
    }
}
