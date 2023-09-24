package com.interview.atlassian.filecollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {
    private Map<String, FileItem> directoryDetailsMap;
    private TopCollectionManager topCollectionManager;
    private int processedFileSize;

    public FileSystem(TopCollectionManager topCollectionManager) {
        this.topCollectionManager = topCollectionManager;
        this.directoryDetailsMap = new HashMap<>();
        this.processedFileSize = 0;
    }

    public int getProcessedFileSize() {
        return this.processedFileSize;
    }

    public List<FileCollection> getNCollection(int n) {
        return topCollectionManager.getTopCollections(n);
    }

    public void addFile(String fileName, int size, String collectionName) {
        File file = new File(fileName, size);
        this.processedFileSize += size;

        if (collectionName == null || collectionName.equals("")) {
            directoryDetailsMap.put(fileName, file);
        } else {
            FileCollection directory = getDirectoryHeap(collectionName);
            directory.addFile(file);
            topCollectionManager.update(directory);
        }
    }

    private FileCollection getDirectoryHeap(String collectionName) {
        FileCollection directory = (FileCollection) directoryDetailsMap.get(collectionName);
        if (directory == null) {
            directory = new FileCollection(collectionName);
            directoryDetailsMap.put(collectionName, directory);
        }
        return directory;
    }
}
