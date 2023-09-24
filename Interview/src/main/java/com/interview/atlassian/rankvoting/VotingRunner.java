package com.interview.atlassian.rankvoting;

public class VotingRunner {

    public static void main(String[] args) {
        VotingByRank votingByRank = new VotingByRank();
        testCase(votingByRank.rankTeams(
                new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}), "ACB");

        testCase(votingByRank.rankTeams(
                new String[]{"WXYZ", "XYZW"}), "XWYZ");

        testCase(votingByRank.rankTeams(
                new String[]{"WYXZ", "WXYZ", "XYZW"}), "WXYZ");

        testCase(votingByRank.rankTeams(
                new String[]{"WXYZ", "XYZW"}), "XWYZ");

        testCase(votingByRank.rankTeams(
                new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}), "ZMNAGUEDSJYLBOPHRQICWFXTVK");
    }

    private static void testCase(String actual, String expected) {
        System.out.println(expected.equals(actual) + " <--test |" + actual + " expected:" + expected);
    }
}
