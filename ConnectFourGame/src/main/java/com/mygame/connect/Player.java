package com.mygame.connect;

import com.mygame.connect.components.Board;
import com.mygame.connect.components.Coin;
import com.mygame.connect.components.MoveEvent;

public class Player {
    private String name;
    private Coin coin;

    public Player(String name, Coin colour) {
        this.name = name;
        this.coin = colour;
    }

    public MoveEvent playMove(Integer column) {
        MoveEvent event = new MoveEvent();
        event.setPlayer(this);
        event.setMoveColumn(column);
        return event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}
