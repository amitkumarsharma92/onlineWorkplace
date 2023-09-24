package com.interview.atlassian.snakegame.strategy;

import com.interview.atlassian.snakegame.board.Coordinates;
import com.interview.atlassian.snakegame.board.IGameBoundary;
import com.interview.atlassian.snakegame.exceptions.SnakeBoundaryHitEvent;

public interface BoundaryStrategy {

    Coordinates transform(Coordinates coordinate, IGameBoundary gameBoundary) throws SnakeBoundaryHitEvent;
}
