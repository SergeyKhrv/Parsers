package com.company.Parsers.DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;
import static com.company.Parsers.DOM.DOMParserUtil.XML_PATH;

public class DOM {
    public static void main(String[] args){
        Document document = DOMParserUtil.parseXMLDocument(XML_PATH);
        Journal journal = new Journal();

        Node journalNode = document.getFirstChild();
        String mainTitle = null;
        Node contactsNode = null;
        Node articlesNode = null;
        NodeList journalNodeList = journalNode.getChildNodes();
        for (int i = 0; i < journalNodeList.getLength(); i++) {
            if (journalNodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (journalNodeList.item(i).getNodeName()) {
                case "title": {
                    mainTitle = journalNodeList.item(i).getTextContent();
                    break;
                }
                case "contacts": {
                    contactsNode = journalNodeList.item(i);
                    break;
                }
                case "articles": {
                    articlesNode = journalNodeList.item(i);
                    break;
                }
            }
        }
        journal.setTitle(mainTitle);

        Contacts contacts = new Contacts();
        NodeList contactsNodeList = contactsNode.getChildNodes();
        for (int i = 0; i < contactsNodeList.getLength(); i++) {
            if (contactsNodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (contactsNodeList.item(i).getNodeName()) {
                case "address": {
                    contacts.setAddress(contactsNodeList.item(i).getTextContent());
                    break;
                }
                case "tel": {
                    contacts.setTelephone(contactsNodeList.item(i).getTextContent());
                    break;
                }
                case "email": {
                    contacts.setEmail(contactsNodeList.item(i).getTextContent());
                    break;
                }
                case "url": {
                    contacts.setUrl(contactsNodeList.item(i).getTextContent());
                    break;
                }
            }
        }
        journal.setContacts(contacts);

        NodeList articlesNodeList = articlesNode.getChildNodes();
        List<Articles> articlesList = new ArrayList<>();
        for (int i = 0; i < articlesNodeList.getLength(); i++) {
            Articles articles = new Articles();
            if (articlesNodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            articles.setId(articlesNodeList.item(i)
                    .getAttributes()
                    .getNamedItem("ID")
                    .getNodeValue());

            NodeList articleNodeList = articlesNodeList.item(i).getChildNodes();
            Node hotkeysNode = null;
            for (int j = 0; j < articleNodeList.getLength(); j++) {
                if (articleNodeList.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (articleNodeList.item(j).getNodeName()) {
                    case "title": {
                        articles.setTitle(articleNodeList.item(j).getTextContent());
                        break;
                    }
                    case "author": {
                        articles.setAuthor(articleNodeList.item(j).getTextContent());
                        break;
                    }
                    case "url": {
                        articles.setUrl(articleNodeList.item(j).getTextContent());
                        break;
                    }
                    case "hotkeys": {
                        hotkeysNode = articleNodeList.item(j);
                        break;
                    }
                }
            }
            NodeList hotkeysNodeList = hotkeysNode.getChildNodes();
            List<String> hotkey = new ArrayList<>();
            for (int k = 0; k < hotkeysNodeList.getLength(); k++) {
                if (hotkeysNodeList.item(k).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                if (hotkeysNodeList.item(k).getTextContent().equals("language") ||
                        hotkeysNodeList.item(k).getTextContent().equals("marckup") ||
                        hotkeysNodeList.item(k).getTextContent().equals("hypertext")) {
                    hotkey.add(hotkeysNodeList.item(k).getTextContent());
                }
            }
            articles.setHotkey(hotkey);
            articlesList.add(articles);
        }
        journal.setArticle(articlesList);
        System.out.println(journal);
    }
}


