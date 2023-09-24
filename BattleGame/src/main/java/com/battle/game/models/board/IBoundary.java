package com.battle.game.models.board;

import java.util.List;

public interface IBoundary {

    List<Coordinate> getAllCoordinates();

    boolean contains(Coordinate coordinate);
}
