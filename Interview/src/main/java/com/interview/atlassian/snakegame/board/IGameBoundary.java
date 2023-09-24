package com.interview.atlassian.snakegame.board;

import com.interview.atlassian.snakegame.board.Coordinates;

public interface IGameBoundary {
    boolean contains(Coordinates coordinates);

    int getMaxWidth();

    int getMaxHeight();
}
