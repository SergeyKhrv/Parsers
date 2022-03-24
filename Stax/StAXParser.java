package com.company.Parsers.Stax;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    private static final String TAG_JOURNAL = "journal";
    private static final String TAG_TITLE = "title";
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_TEL = "tel";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_URL = "url";
    private static final String TAG_ARTICLES = "articles";
    private static final String TAG_ARTICLE = "article";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_HOTKEYS = "hotkeys";
    private static final String TAG_HOTKEY = "hotkey";
    private static final String ATTRIBUTE_ID = "ID";

    public StAXJournal buildJournal() throws XMLStreamException {
        StAXJournal stAXJournal = new StAXJournal();
        XMLStreamReader reader = StAXParserUtil.createXMLStreamReader();
        String tagName;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    tagName = reader.getLocalName();
                    switch (tagName) {
                        case TAG_TITLE -> stAXJournal.setTitle(findJournalTitle());
                        case TAG_CONTACTS -> stAXJournal.setContacts(buildContacts());
                        case TAG_ARTICLES -> stAXJournal.setArticle(buildSetArticles());
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    tagName = reader.getLocalName();
                    if (tagName.equals(TAG_JOURNAL)) {
                        return stAXJournal;
                    }
                }
            }
        }
        throw new XMLStreamException();
    }

    public String findJournalTitle() throws XMLStreamException {
        XMLStreamReader reader = StAXParserUtil.createXMLStreamReader();
        String tagName;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    tagName = reader.getLocalName();
                    if (TAG_TITLE.equals(tagName)) {
                        return reader.getElementText();
                    }
                }
            }
        }
        throw new XMLStreamException();
    }

    public StAXContacts buildContacts() throws XMLStreamException {
        StAXContacts stAXContacts = new StAXContacts();
        XMLStreamReader reader = StAXParserUtil.createXMLStreamReader();
        String tagName;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    tagName = reader.getLocalName();
                    switch (tagName) {
                        case TAG_ADDRESS -> stAXContacts.setAddress(reader.getElementText());
                        case TAG_TEL -> stAXContacts.setTelephone(reader.getElementText());
                        case TAG_EMAIL -> stAXContacts.setEmail(reader.getElementText());
                        case TAG_URL -> stAXContacts.setUrl(reader.getElementText());
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    tagName = reader.getLocalName();
                    if (tagName.equals(TAG_CONTACTS)) {
                        return stAXContacts;
                    }
                }
            }
        }
        throw new XMLStreamException();
    }

    public List<StAXArticles> buildSetArticles() throws XMLStreamException {
        List<StAXArticles> articles = new ArrayList<>();
        XMLStreamReader reader = StAXParserUtil.createXMLStreamReader();
        String tagName;
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                tagName = reader.getLocalName();
                if (TAG_ARTICLE.equals(tagName)) {
                    StAXArticles stAXArticles = buildArticles(reader);
                    articles.add(stAXArticles);
                }
            }
        }
        return articles;
    }

    public StAXArticles buildArticles(XMLStreamReader reader) throws XMLStreamException {
        StAXArticles stAXArticles = new StAXArticles();
        stAXArticles.setId(reader.getAttributeValue(null, ATTRIBUTE_ID));
        String tagName;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    tagName = reader.getLocalName();

                    switch (tagName) {
                        case TAG_TITLE -> stAXArticles.setTitle(reader.getElementText());
                        case TAG_AUTHOR -> stAXArticles.setAuthor(reader.getElementText());
                        case TAG_URL -> stAXArticles.setUrl(reader.getElementText());
                        case TAG_HOTKEYS -> stAXArticles.setHotkey(buildHotkeys(reader));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    tagName = reader.getLocalName();
                    if (tagName == TAG_ARTICLE) {
                        return stAXArticles;
                    }
                }
            }
        }
        throw new XMLStreamException();
    }

    public List<String> buildHotkeys(XMLStreamReader reader) throws XMLStreamException {
        List<String> hotkey = new ArrayList<>();
        String tagName;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    tagName = reader.getLocalName();
                    if (TAG_HOTKEY.equals(tagName)) {
                        hotkey.add(reader.getElementText());
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    tagName = reader.getLocalName();
                    if (tagName.equals(TAG_HOTKEYS)) {
                        return hotkey;
                    }
                }
            }
        }
        throw new XMLStreamException();
    }
}
