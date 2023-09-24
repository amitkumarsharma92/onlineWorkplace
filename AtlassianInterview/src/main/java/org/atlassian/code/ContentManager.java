package org.atlassian.code;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class ContentManager {
    SortedSet<Content> contentSet;
    Map<String, Content> contentMap = new HashMap<>();

    public ContentManager() {
        this.contentSet = new TreeSet<>();
    }

    public void increasePopularity(String contentId) {
        Content content = findContent(contentId);
        contentSet.remove(content);
        content.increasePopularity();
        contentSet.add(content);
    }

    public void decreasePopularity(String contentId) {
        Content content = findContent(contentId);
        contentSet.remove(content);
        content.decreasePopularity();
        contentSet.add(content);
    }

    public String mostPopular() {
        String result = !contentSet.isEmpty()
                ? contentSet.last().getContentId() : "0";
        System.out.println("Most Popular" + result);
        return result;
    }

    private Content findContent(String contentId) {
        Content content = contentMap.get(contentId);
        if (content == null) {
            content = new Content(contentId);
            contentMap.put(contentId, content);
        }
        return content;
    }

}
