package com.battle.game.models.ship;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.board.BoardItem;
import com.battle.game.models.board.Coordinate;
import com.battle.game.models.board.IBoundary;

public class Ship extends BoardItem {

    public Ship(ShipType type, IBoundary boundary) {
        super(type.name(), boundary);
    }

    public void acceptHit(Coordinate coordinate) throws InvalidInputException {
        if (boundary.contains(coordinate)) {
            hits.add(coordinate);
        }
        if (hits.size() >= boundary.getAllCoordinates().size()) {
            status = BoardItemStatus.SUNK;
        }
    }
}
