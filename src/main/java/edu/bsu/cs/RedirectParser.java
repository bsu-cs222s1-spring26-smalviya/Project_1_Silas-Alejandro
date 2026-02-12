package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RedirectParser {

    public static List<Redirect> parse(InputStream inputStream) {
        Object json = JsonPath.parse(inputStream).json();

        List<Map<String, Object>> rawRedirects =
                JsonPath.read(json, "$.query.redirects[*]");

        List<Redirect> redirects = new ArrayList<>();

        for (Map<String, Object> redirect : rawRedirects) {
            redirects.add(new Redirect(
                    (String) redirect.get("from"),
                    (String) redirect.get("to")
            ));
        }

        return redirects;
    }

}
