package com.company.Parsers.Stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParserUtil {
    static final String XML_PATH = "XML_Parser_home_task";

    public static XMLStreamReader createXMLStreamReader() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            return factory.createXMLStreamReader(
                    ClassLoader.getSystemResourceAsStream(XML_PATH));
        } catch (XMLStreamException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException log");
            return null;
        }
    }
}
