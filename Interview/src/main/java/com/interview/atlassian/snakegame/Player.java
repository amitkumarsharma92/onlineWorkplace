package com.interview.atlassian.snakegame;

import java.util.ArrayDeque;
import java.util.Deque;

public class Player {
    private String name;

    Deque<InputDirection> pendingPlayerMoves = new ArrayDeque<>();

    public Player(String name) {
        this.name = name;
    }

    public void play(InputDirection inputEvent) {
        pendingPlayerMoves.addLast(inputEvent);
    }

    public boolean hasPendingMove() {
        return pendingPlayerMoves.size() > 0;
    }

    public InputDirection getPendingMove() {
        return pendingPlayerMoves.removeFirst();
    }
}
