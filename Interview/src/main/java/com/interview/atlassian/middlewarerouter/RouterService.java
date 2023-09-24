package com.interview.atlassian.middlewarerouter;

public class RouterService {

    TrieNode node;

    public RouterService() {
        this.node = new TrieNode();
    }

    public void add(String route, String data) {
        node.addChildren(route, data);
    }

    public String get(String route) {
        return node.get(route);
    }
}
