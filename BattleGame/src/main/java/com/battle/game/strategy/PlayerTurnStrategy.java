package com.battle.game.strategy;

import com.battle.game.models.Player;

public interface PlayerTurnStrategy {
    int getFirstPlayer();

    int getNextPlayer(int index);

    Player getPlayer(int index);
}
