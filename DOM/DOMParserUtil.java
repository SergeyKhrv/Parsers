package com.company.Parsers.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParserUtil {
    static final String XML_PATH = "XML_Parser_home_task";

    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try {
            return factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException log");
            return null;
        }
    }

    public static Document parseXMLDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
            } catch (SAXException e) {
                e.printStackTrace();
                System.out.println("SAXException log");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException log");
            }
        }
        return document;
    }
}
