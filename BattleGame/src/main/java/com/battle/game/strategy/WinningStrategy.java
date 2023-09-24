package com.battle.game.strategy;

import com.battle.game.models.Player;
import com.battle.game.models.PlayerStatus;

import java.util.ArrayList;
import java.util.List;

public class WinningStrategy {

    public Player checkWinner(List<Player> playerList) {
        List<Player> active = new ArrayList<>();
        for (Player player : playerList) {
            if (player.getStatus() == PlayerStatus.ACTIVE) {
                active.add(player);
            }
        }
        if (active.size() == 1) {
            return active.get(0);
        } else return null;
    }
}
