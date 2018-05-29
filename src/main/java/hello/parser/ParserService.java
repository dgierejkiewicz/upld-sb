package hello.parser;

import org.apache.tika.exception.TikaException;
import org.xml.sax.ContentHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public interface ParserService {

    void init();

    String parse(FileInputStream stream, ContentHandler handler,
                 Metadata metadata, ParseContext context) throws IOException, SAXException, TikaException;

}
