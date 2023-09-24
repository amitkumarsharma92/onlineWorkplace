package com.interview.atlassian.filecollection;

class File extends FileItem {
    FileCollection directory;

    public File(String name, int size, FileCollection directory) {
        this(name, size);
        this.directory = directory;
    }

    public File(String name, int size) {
        super(name, size);
    }
}