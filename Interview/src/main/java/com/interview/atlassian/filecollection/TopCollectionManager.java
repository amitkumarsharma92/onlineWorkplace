package com.interview.atlassian.filecollection;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopCollectionManager {
    PriorityQueue<FileCollection> directoryHeap;

    public TopCollectionManager() {
        this.directoryHeap = new PriorityQueue<>((a, b) -> b.size - a.size);
    }

    public List<FileCollection> getTopCollections(int n) {
        n = Math.min(this.directoryHeap.size(), n);

        List<FileCollection> output = new ArrayList<>();
        for (int i = 0; i < n; i++)
            output.add(this.directoryHeap.poll());

        this.directoryHeap.addAll(output);
        return output;
    }

    public void update(FileCollection directory) {
        directoryHeap.remove(directory);
        directoryHeap.add(directory);
    }
}
