package com.company.Parsers.Stax;

import java.util.List;

public class StAXArticles {
    private String id;
    private String title;
    private String author;
    private String url;
    private List<String> hotkey;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHotkey(List<String> hotkey) {
        this.hotkey = hotkey;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getHotkey() {
        return hotkey;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkey=" + hotkey +
                '}';
    }
}
