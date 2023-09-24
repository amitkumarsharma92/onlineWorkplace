package com.battle.game.models.board;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.ship.BoardItemStatus;

import java.util.List;

public abstract class BoardItem {
    protected String name;
    protected IBoundary boundary;
    protected BoardItemStatus status;

    protected List<Coordinate> hits;

    public BoardItem(String name, IBoundary boundary) {
        this.name = name;
        this.boundary = boundary;
        this.status = BoardItemStatus.ACTIVE;
    }

    public IBoundary getBoundary() {
        return boundary;
    }

    public void setBoundary(IBoundary boundary) {
        this.boundary = boundary;
    }

    public String getName() {
        return name;
    }

    public BoardItemStatus getStatus() {
        return status;
    }

    public abstract void acceptHit(Coordinate coordinate) throws InvalidInputException;
}
