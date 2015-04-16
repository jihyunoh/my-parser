package edu.usc.jihyunoh;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ToXMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class UrlParser {
	
    public static void main(final String[] args) throws IOException,
SAXException, TikaException {

            // create list
            List<String> domain = new ArrayList<String>();

            domain.add("https://github.com/johnmccutchan/javelin/blob/master/AUTHORS.txt");
//          domain.add("https://github.com/PadreIDE/Authors/blob/master/authors");
//          domain.add("https://github.com/johnmccutchan/javelin/blob/master/AUTHORS.txt");

            Parser parser = new AutoDetectParser();
//          WriteFile wf = new WriteFile("/Users/ohjihyun/mytika/parser_url.txt", true);


            try {

                    for (int i = 0; i < domain.size(); i++) {

                            System.out.println(domain.get(i));
                            extractFromFile(parser, domain.get(i));

                    }
            }
            catch (IOException e) {
            System.out.println(e.getMessage());

            }


    }
    public static void extractFromFile(final Parser parser,
            final String domain) throws IOException, SAXException,
            TikaException {

       ContentHandler handler = new ToXMLContentHandler();
       Metadata metadata = new Metadata();
       URL url = new URL(domain);
       InputStream stream = url.openStream();

       parser.parse(stream, handler, metadata, new ParseContext());


       System.out.println("MetaData-----------------------------");
//     System.out.println(metadata.toString());
       System.out.println(metadata.get("Content-Type"));
//     System.out.println("XHTML--------------------------------");
//     System.out.println(handler.toString());

}

}
