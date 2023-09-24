package com.battle.game.models;

import com.battle.game.models.board.Coordinate;

public class PlayerChanceTarget {
    Player player;
    Coordinate target;

    public PlayerChanceTarget(Player player, Coordinate target) {
        this.player = player;
        this.target = target;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Coordinate getTarget() {
        return target;
    }

    public void setTarget(Coordinate target) {
        this.target = target;
    }
}
