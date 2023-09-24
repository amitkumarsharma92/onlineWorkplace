package com.battle.game.models.board;

import java.util.ArrayList;
import java.util.List;

public class RectangularBoundary implements IBoundary {

    private Coordinate start;
    private int width;
    private int breadth;

    private List<Coordinate> allCoordinates;

    public RectangularBoundary(Coordinate start, int width, int breadth) {
        this.start = start;
        this.breadth = breadth;
        this.width = width;
        allCoordinates = new ArrayList<>();
        for (int i = 0; i < breadth; i++) {
            for (int j = 0; j < width; j++) {
                allCoordinates.add(new Coordinate(i + start.getX(), j + start.getY()));
            }
        }
    }

    @Override
    public List<Coordinate> getAllCoordinates() {
        return allCoordinates;
    }

    @Override
    public boolean contains(Coordinate coordinate) {
        return coordinate.getX() >= start.getX()
                && coordinate.getX() <= (start.getX() + breadth)
                && coordinate.getY() >= start.getY()
                && coordinate.getY() <= (start.getY() + width);
    }
}
