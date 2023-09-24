package com.interview.atlassian.rankvoting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Supplier;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 */
public class VotingByRank {

    public String rankTeams(String[] votes) {
        if (votes.length == 0) return "";
        if (votes.length == 1) return votes[0];
        int candidateSize = votes[0].length();

        Map<Character, VoteRank> candidateVoteMap = new HashMap<>();

        for (String vote : votes) {
            for (int rank = 0; rank < candidateSize; rank++) {
                addRankVote(vote.charAt(rank), rank, candidateVoteMap, candidateSize);
            }
        }

        Supplier<Comparator<VoteRank>> comparatorSupplier = () -> (a, b) -> {
            int[] aVote = a.getVotesMatrix(), bVote = b.getVotesMatrix();
            for (int i = 0; i < aVote.length; i++) {
                if (aVote[i] == bVote[i]) continue;
                return bVote[i] - aVote[i];
            }
            return 1;
        };

        PriorityQueue<VoteRank> voteHeap = new PriorityQueue<>(candidateSize, comparatorSupplier.get());

        StringBuilder rankings = new StringBuilder();
        for (VoteRank voteRank : candidateVoteMap.values()) {
            voteHeap.add(voteRank);
        }

        while (!voteHeap.isEmpty()) {
            rankings.append(voteHeap.poll().getName());
        }
        return rankings.toString();
    }

    private void addRankVote(Character candidate, int rank, Map<Character, VoteRank> candidateVoteMap, int candidateSize) {
        VoteRank voteRank = candidateVoteMap.get(candidate);
        if (voteRank == null) {
            voteRank = new VoteRank(candidate, new int[candidateSize]);
            candidateVoteMap.put(candidate, voteRank);
        }
        voteRank.addVote(rank);
    }

}
