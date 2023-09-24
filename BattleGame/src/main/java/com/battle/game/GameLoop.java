package com.battle.game;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.Player;
import com.battle.game.models.PlayerChanceTarget;
import com.battle.game.strategy.PlayerTurnStrategy;
import com.battle.game.strategy.WinningStrategy;

import java.util.List;

public class GameLoop {

    List<Player> playerList;
    PlayerTurnStrategy playerTurnStrategy;
    private WinningStrategy winningStrategy;

    public GameLoop(PlayerTurnStrategy playerTurnStrategy, List<Player> playerList) {
        this.playerList = playerList;
        this.playerTurnStrategy = playerTurnStrategy;
    }

    public void start() {
        int currentPlayerNum = playerTurnStrategy.getFirstPlayer();
        try {
            Player currentPlayer = playerList.get(currentPlayerNum);
            PlayerChanceTarget playerChanceTarget = currentPlayer.playTurn(playerList);
            Player targetPlayer = playerChanceTarget.getPlayer();
            targetPlayer.takeHit(playerChanceTarget.getTarget());

            Player player  = winningStrategy.checkWinner(playerList);
            if (player != null){
                //print player won
            }
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }
}
