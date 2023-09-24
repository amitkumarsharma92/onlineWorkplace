package org.atlassian.code;

public class Content implements Comparable {
    private String contentId;
    private int popularity;

    public Content(String content) {
        this.contentId = content;
        this.popularity = 0;
    }

    public String getContentId() {
        return contentId;
    }

    public void increasePopularity() {
        this.popularity++;
    }

    public void decreasePopularity() {
        this.popularity--;
    }

    @Override
    public int compareTo(Object o) {
        if (this.popularity == ((Content) o).popularity) {
            return this.contentId.compareTo(((Content) o).contentId);
        }
        return this.popularity - ((Content) o).popularity;
    }
}
