package org.skypro.skyshop.article;

import org.skypro.skyshop.searchEngine.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String body;

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return this.getTitle() + System.lineSeparator() + this.getBody();
    }

    @Override
    public String getSearchTerm() {
        return this.getTitle() + " " + this.getBody();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return this.getTitle();
    }
}
