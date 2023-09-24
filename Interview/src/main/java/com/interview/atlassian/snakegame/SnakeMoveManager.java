package com.interview.atlassian.snakegame;

import com.interview.atlassian.snakegame.board.Coordinates;
import com.interview.atlassian.snakegame.board.GameState;
import com.interview.atlassian.snakegame.board.items.Snake;
import com.interview.atlassian.snakegame.exceptions.SnakeBiteEvent;
import com.interview.atlassian.snakegame.exceptions.SnakeBoundaryHitEvent;
import com.interview.atlassian.snakegame.strategy.BoundaryStrategy;

public class SnakeMoveManager {
    private Snake snake;
    private BoundaryStrategy strategy;

    GameState gameState;

    public SnakeMoveManager(Snake snake, BoundaryStrategy strategy) {
        this.snake = snake;
        this.strategy = strategy;
    }

    public boolean move(Coordinates prey) throws SnakeBiteEvent, SnakeBoundaryHitEvent {
        return move(prey, snake.getLastDirection());
    }

    public Boolean move(Coordinates prey, InputDirection direction) throws SnakeBiteEvent, SnakeBoundaryHitEvent {
        if (!valid(direction, snake.getLastDirection())) {
            return null;
        }
        Coordinates nextCoordinate = nextCoordinate(snake.getSnakeHead(), direction);
        nextCoordinate = validate(nextCoordinate);

        boolean eaten = (nextCoordinate.equals(prey));
        snake.addmove(nextCoordinate, eaten);
        snake.setLastDirection(direction);
        return eaten;
    }

    private boolean valid(InputDirection inputDirection, InputDirection lastDirection) {
        switch (inputDirection) {
            case UP:
                return lastDirection != InputDirection.DOWN;
            case DOWN:
                return lastDirection != InputDirection.UP;
            case LEFT:
                return lastDirection != InputDirection.RIGHT;
            case RIGHT:
                return lastDirection != InputDirection.LEFT;
        }
        return true;
    }


    private Coordinates validate(Coordinates nextCoordinate) throws SnakeBiteEvent, SnakeBoundaryHitEvent {
        if (snake.occupiedCoordinate(nextCoordinate)) {
            throw new SnakeBiteEvent();
        }
        nextCoordinate = strategy.transform(nextCoordinate, gameState.getGameBoundary());
        return nextCoordinate;
    }

    private Coordinates nextCoordinate(Coordinates head, InputDirection inputDirection) {
        int x = head.getX(), y = head.getY();
        switch (inputDirection) {
            case UP:
                x--;
                break;
            case DOWN:
                x++;
                break;

            case LEFT:
                y--;
                break;
            case RIGHT:
                y++;
                break;
        }
        return new Coordinates(x, y);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Snake getSnake() {
        return snake;
    }
}
