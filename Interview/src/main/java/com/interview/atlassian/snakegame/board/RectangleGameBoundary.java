package com.interview.atlassian.snakegame.board;

public class RectangleGameBoundary implements IGameBoundary {
    private Coordinates start;
    private int height;
    private int width;

    public RectangleGameBoundary(Coordinates start, int height, int width) {
        this.start = start;
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean contains(Coordinates coordinates) {
        return coordinates.getX() >= this.start.getX()
                && coordinates.getX() < this.start.getX() + width
                && coordinates.getX() >= this.start.getY()
                && coordinates.getX() < this.start.getY() + height;
    }

    @Override
    public int getMaxWidth() {
        return width;
    }

    @Override
    public int getMaxHeight() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
