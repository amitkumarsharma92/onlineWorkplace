package com.interview.atlassian.filecollection;

public abstract class FileItem {
    public String name;
    public int size;

    public FileItem(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
