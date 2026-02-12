package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.Path;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RedirectParser {

    public static List<Redirect> parse(Object json) {

        List<Map<String, Object>> rawRedirects;
        try {
            rawRedirects = JsonPath.read(json, "$.query.redirects[*]");
        } catch (PathNotFoundException e) {
            rawRedirects = new ArrayList<>();
        }

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
