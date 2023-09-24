package com.interview.atlassian.filecollection;

import java.util.ArrayList;
import java.util.List;

class FileCollection extends FileItem {

    List<File> files;

    public FileCollection(String name) {
        super(name, 0);
        files = new ArrayList<>();
    }

    public void addFile(File newfile) {
        this.files.add(newfile);
        this.size += newfile.getSize();
    }
}