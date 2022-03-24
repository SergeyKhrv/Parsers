package com.company.Parsers.DOM;

import java.util.List;

public class Journal {
    private String title;
    private Contacts contacts;
    private List<Articles> articles;

    public String getTitle() {
        return title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public List<Articles> getArticle() {
        return articles;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setArticle(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", contacts=" + contacts +
                ", articles=" + articles +
                '}';
    }
}
