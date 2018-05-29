package hello.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class ParserServiceHtml {

    public String parse(String path) throws IOException {

        Document doc = Jsoup.parse(new File(path), "UTF-8");
        Element masthead = doc.select("div.content").first();
        return masthead.toString();
    }
}
