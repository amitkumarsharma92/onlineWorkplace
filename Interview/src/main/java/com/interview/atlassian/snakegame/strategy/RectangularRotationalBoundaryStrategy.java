package com.interview.atlassian.snakegame.strategy;

import com.interview.atlassian.snakegame.board.Coordinates;
import com.interview.atlassian.snakegame.board.IGameBoundary;
import com.interview.atlassian.snakegame.board.RectangleGameBoundary;

public class RectangularRotationalBoundaryStrategy implements BoundaryStrategy {

    @Override
    public Coordinates transform(Coordinates coordinate, IGameBoundary gameBoundary) {
        RectangleGameBoundary rectangleGameBoundary = (RectangleGameBoundary) gameBoundary;
        if (coordinate.getX() < 0) {
            coordinate.setX(rectangleGameBoundary.getWidth() - 1);
        }
        if (coordinate.getX() >= rectangleGameBoundary.getWidth()) {
            coordinate.setX(0);
        }
        if (coordinate.getY() < 0) {
            coordinate.setY(rectangleGameBoundary.getHeight() - 1);
        }
        if (coordinate.getY() >= rectangleGameBoundary.getHeight()) {
            coordinate.setY(0);
        }
        return coordinate;
    }
}
