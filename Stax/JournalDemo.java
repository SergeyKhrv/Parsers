package com.company.Parsers.Stax;

import javax.xml.stream.XMLStreamException;

public class JournalDemo {
    public static void main(String[] args) throws XMLStreamException {
        StAXParser stAXParser = new StAXParser();
        System.out.println(stAXParser.buildJournal());
    }
}
