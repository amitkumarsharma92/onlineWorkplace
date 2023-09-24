package com.interview.atlassian.filecollection;

import java.util.List;

public class Runner {

    public static void main(String args[]) {

        FileSystem fileSystem = new FileSystem(new TopCollectionManager());

        fileSystem.addFile("file1.txt", 100, "");
        fileSystem.addFile("file2.txt", 100, "collection1");
        fileSystem.addFile("file3.txt", 200, "collection1");
        fileSystem.addFile("file4.txt", 300, "collection3");
        fileSystem.addFile("file5.txt", 400, "collection4");

        fileSystem.addFile("file6.txt", 500, "collection3");

        System.out.println(fileSystem.getProcessedFileSize() + "---");
        printTopCollections(fileSystem, 4);
        fileSystem.addFile("file7.txt", 600, "collection2");
        printTopCollections(fileSystem, 3);
    }

    private static void printTopCollections(FileSystem fileSystem, int n) {
        List<FileCollection> topNCollections = fileSystem.getNCollection(n);

        for (FileCollection collection : topNCollections)
            System.out.println(collection.name + " " + collection.size + " ");
        System.out.println("------------------------");
    }
}
