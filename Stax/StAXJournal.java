package com.company.Parsers.Stax;

import java.util.List;

public class StAXJournal {
    private String title;
    private StAXContacts contacts;
    private List<StAXArticles> articles;

    public String getTitle() {
        return title;
    }

    public StAXContacts getContacts() {
        return contacts;
    }

    public List<StAXArticles> getArticle() {
        return articles;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContacts(StAXContacts contacts) {
        this.contacts = contacts;
    }

    public void setArticle(List<StAXArticles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "StAXJournal{" +
                "title='" + title + '\'' +
                ", contacts=" + contacts +
                ", articles=" + articles +
                '}';
    }
}
