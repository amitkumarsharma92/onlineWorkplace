package com.interview.atlassian.snakegame.board.items;

import com.interview.atlassian.snakegame.InputDirection;
import com.interview.atlassian.snakegame.board.Coordinates;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private InputDirection lastDirection;
    private Deque<Coordinates> locations = new ArrayDeque<>();

    public Snake(InputDirection lastDirection, Coordinates start) {
        this.lastDirection = lastDirection;
        this.locations.add(start);
        this.locations.add(new Coordinates(start.getX(), start.getY()));
    }

    public Coordinates getSnakeHead() {
        return locations.getFirst();
    }

    public Coordinates getSnakeTail() {
        return locations.getLast();
    }

    public boolean occupiedCoordinate(Coordinates coordinates) {
        return locations.contains(coordinates);
    }

    public void addmove(Coordinates nextCoordinate, boolean eaten) {
        locations.addFirst(nextCoordinate);
        if (!eaten) locations.removeLast();
    }

    public InputDirection getLastDirection() {
        return lastDirection;
    }

    public void setLastDirection(InputDirection lastDirection) {
        this.lastDirection = lastDirection;
    }
}
