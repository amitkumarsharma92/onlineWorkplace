package com.battle.game.models;

import com.battle.game.models.board.Coordinate;

public class PlayerInput {
    private Coordinate coordinate;

    private int playerNum;

    public PlayerInput(Coordinate coordinate, int playerNum) {
        this.coordinate = coordinate;
        this.playerNum = playerNum;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
}
