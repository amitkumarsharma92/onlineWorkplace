package com.battle.game.models;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.board.Board;
import com.battle.game.models.board.BoardItem;
import com.battle.game.models.board.Coordinate;
import com.battle.game.models.ship.BoardItemStatus;
import com.battle.game.strategy.ChanceGenerationStrategy;

import java.util.List;

public class Player {
    private String name;

    private Board board;

    public PlayerStatus getStatus() {
        return status;
    }

    private PlayerStatus status;

    private ChanceGenerationStrategy strategy;

    public Player(String name, Board board, ChanceGenerationStrategy strategy) {
        this.name = name;
        this.board = board;
        this.strategy = strategy;
        status = PlayerStatus.ACTIVE;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public PlayerChanceTarget playTurn(List<Player> allPlayers) throws InvalidInputException {
        return strategy.getPlayerTarget(allPlayers);
    }

    public void takeHit(Coordinate coordinate) throws InvalidInputException {
        board.acceptHit(coordinate);
        for (BoardItem item : board.getBoardItems()) {
            if (item.getStatus() == BoardItemStatus.ACTIVE) {
                return;
            }
        }
        status = PlayerStatus.LOST;
    }
}
