package hello.parser;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;

public class FileParserService {

    private ParserService parser;

    public FileParserService() {
    }

    public String parseFile(String contentType, String path) throws IOException, TikaException, SAXException {

        BodyContentHandler handler  = new BodyContentHandler();
        Metadata metadata           = new Metadata();
        FileInputStream stream      = new FileInputStream(new File(path));
        ParseContext context        = new ParseContext();
        String content = "";

        switch (contentType) {
            case "text/html":
                ParserServiceHtml htmlParser = new ParserServiceHtml();
                content = htmlParser.parse(path);
                break;
            case "application/msword":
                ParserServiceDoc docParser = new ParserServiceDoc();
                content = docParser.parse(stream, handler, metadata, context);
                break;
            case "application/vnd.openxmlformats":
                ParserServiceDocx docxParser = new ParserServiceDocx();
                content = docxParser.parse(stream, handler, metadata, context);
                break;
            case "application/vnd.oasis.opendocument.text":
                ParserServiceOdt odtParser = new ParserServiceOdt();
                content = odtParser.parse(stream, handler, metadata, context);
                break;
            case "application/rtf":
                ParserServiceRtf rtfParser = new ParserServiceRtf();
                content = rtfParser.parse(stream, handler, metadata, context);
                break;
            case "application/pdf":
                ParserServicePdf pdfParser = new ParserServicePdf();
                content = pdfParser.parse(stream, handler, metadata, context);
                break;

        }

        return content;

    }
}
