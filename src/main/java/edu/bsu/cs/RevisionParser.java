package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RevisionParser {

    public List<Revision> parse(InputStream inputStream) {
        Object json = JsonPath.parse(inputStream).json();

        List<Map<String, Object>> rawRevisions =
                JsonPath.read(json, "$.query.pages.*.revisions[*]");

        List<Revision> revisions = new ArrayList<>();

        for (Map<String, Object> revision : rawRevisions) {
            revisions.add(new Revision(
                    (String) revision.get("user"),
                    (String) revision.get("timestamp")
            ));
        }

        return revisions;
    }
}

