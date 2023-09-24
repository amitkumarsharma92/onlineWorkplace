package com.interview.atlassian.rankvoting;

public class VoteRank {
    char name;
    int[] votesMatrix;

    public VoteRank(char name, int[] votesMatrix) {
        this.name = name;
        this.votesMatrix = votesMatrix;
    }

    public void addVote(int rank) {
        votesMatrix[rank]++;
    }

    public int[] getVotesMatrix() {
        return votesMatrix;
    }

    public char getName() {
        return name;
    }
}