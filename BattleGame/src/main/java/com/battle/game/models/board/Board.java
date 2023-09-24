package com.battle.game.models.board;

import com.battle.game.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    IBoundary boundary;
    List<BoardItem> boardItems;

    protected List<Coordinate> hits = new ArrayList<>();

    public Board(IBoundary boundary, List<BoardItem> boardItems) {
        this.boundary = boundary;
        this.boardItems = boardItems;
    }

    public IBoundary getBoundary() {
        return boundary;
    }

    public List<BoardItem> getBoardItems() {
        return boardItems;
    }

    public List<Coordinate> getHits() {
        return hits;
    }

    public void setHits(List<Coordinate> hits) {
        this.hits = hits;
    }

    public void acceptHit(Coordinate coordinate) throws InvalidInputException {
        if (!boundary.contains(coordinate)){
            throw new InvalidInputException();
        }

        for( BoardItem ships : boardItems){
            ships.getBoundary().contains(coordinate);
            ships.acceptHit(coordinate);
            break;
        }
    }
}
