package com.battle.game.strategy;

import com.battle.game.models.Player;

import java.util.List;

public class RRPlayerTurnStrategy implements PlayerTurnStrategy {
    List<Player> playerList;

    public RRPlayerTurnStrategy(List<Player> playerList) {
        super();
        this.playerList = playerList;
    }

    public int getFirstPlayer() {
        return 0;
    }

    @Override
    public int getNextPlayer(int index) {
        return index % playerList.size();
    }

    @Override
    public Player getPlayer(int index) {
        return playerList.get(index);
    }
}
