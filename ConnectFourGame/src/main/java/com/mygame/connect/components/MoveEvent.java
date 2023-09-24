package com.mygame.connect.components;

import com.mygame.connect.Player;

public class MoveEvent {
    private Player player;
    private Coin[][] gameState;
    private int moveColumn;
    private int moveRow;
    private boolean isEndState;
    private boolean isInvalidMove;

    public MoveEvent(){
        super();
    }
    public MoveEvent(Player player, Coin[][] playState, int moveColumn, int moveRow) {
        super();
        this.player = player;
        this.gameState = playState;
        this.moveColumn = moveColumn;
        this.moveRow = moveRow;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Coin[][] getGameState() {
        return gameState;
    }

    public void setGameState(Coin[][] gameState) {
        this.gameState = gameState;
    }

    public int getMoveColumn() {
        return moveColumn;
    }

    public void setMoveColumn(int moveColumn) {
        this.moveColumn = moveColumn;
    }

    public int getMoveRow() {
        return moveRow;
    }

    public void setMoveRow(int moveRow) {
        this.moveRow = moveRow;
    }

    public boolean isEndState() {
        return isEndState;
    }

    public void setEndState(boolean endState) {
        isEndState = endState;
    }

    public boolean isInvalidMove() {
        return isInvalidMove;
    }

    public void setInvalidMove(boolean invalidMove) {
        isInvalidMove = invalidMove;
    }
}
