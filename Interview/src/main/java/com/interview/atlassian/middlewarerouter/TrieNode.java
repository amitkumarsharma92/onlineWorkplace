package com.interview.atlassian.middlewarerouter;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<String, TrieNode> children;
    String value;
    boolean end;

    public TrieNode() {
        this.children = new HashMap<>();
        this.value = "";
    }

    public TrieNode(String value) {
        this.value = value;
        this.end = true;
    }

    public String get(String route) {
        String[] routes = route.split("/", 2);
        String nodeRouter = routes[0];


        if (children.containsKey(nodeRouter)) {
            TrieNode nextChild = children.get(nodeRouter);
            if (routes.length == 1) return nextChild.getValue();
            else return nextChild.get(routes[1]);
        } else {
            return null;
        }
    }


    public void addChildren(String route, String value) {
        String[] routes = route.split("/", 2);

        //Will act like Leaf
        if (routes.length == 1) {
            children.put(route, new TrieNode(value));
            return;
        }

        //Add as Child and reRoute again
        String nodeRouter = routes[0];
        TrieNode node;
        if (children.containsKey(nodeRouter)) {
            node = children.get(nodeRouter);
        } else {
            node = new TrieNode();
            children.put(nodeRouter, node);
        }
        node.addChildren(routes[1], value);
    }


    public Map<String, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<String, TrieNode> children) {
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
