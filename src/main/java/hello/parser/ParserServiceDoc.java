package hello.parser;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;

public class ParserServiceDoc implements ParserService {
    @Override
    public void init() {

    }

    @Override
    public String parse(FileInputStream stream, ContentHandler handler, Metadata metadata, ParseContext context) throws IOException, SAXException, TikaException {

        OOXMLParser  msofficeparser = new OOXMLParser();
        msofficeparser.parse(stream, handler, metadata, context);

        return handler.toString();
    }
}
