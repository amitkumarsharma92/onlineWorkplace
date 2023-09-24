package com.interview.atlassian.snakegame.board;

import com.interview.atlassian.snakegame.InputDirection;
import com.interview.atlassian.snakegame.Player;
import com.interview.atlassian.snakegame.SnakeMoveManager;
import com.interview.atlassian.snakegame.board.Coordinates;
import com.interview.atlassian.snakegame.board.IGameBoundary;
import com.interview.atlassian.snakegame.board.items.Snake;
import com.interview.atlassian.snakegame.exceptions.SnakeBiteEvent;
import com.interview.atlassian.snakegame.exceptions.SnakeBoundaryHitEvent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameState {
    Random random;
    private Player player;
    private IGameBoundary gameBoundary;
    private SnakeMoveManager snakeMoveManager;
    private Snake snake;

    private Coordinates prey;

    public GameState(Player player, IGameBoundary gameBoundary, SnakeMoveManager snakeMoveManager) {
        this.player = player;
        this.gameBoundary = gameBoundary;
        this.snakeMoveManager = snakeMoveManager;
        this.snake = snakeMoveManager.getSnake();
        this.random = new Random();
        snakeMoveManager.setGameState(this);
    }

    public void gameLoop() {
        try {
            testGame();
        } catch (SnakeBiteEvent e) {
            System.out.println("Game Over|Self Bite");
        } catch (SnakeBoundaryHitEvent e) {
            System.out.println("Game Over| Boundary");
        } catch (InterruptedException e) {
            System.out.println("Game Exited Abruptly");
            throw new RuntimeException(e);
        }
    }

    public void nextState() throws SnakeBiteEvent, SnakeBoundaryHitEvent {
        if (player.hasPendingMove()) {
            int counter = 0;
            Set<InputDirection> directionSet = new HashSet<>();
            while (player.hasPendingMove() && counter < 2) {
                InputDirection userDirection = player.getPendingMove();
                if (directionSet.contains(userDirection)) continue;
                directionSet.add(userDirection);
                Boolean eaten = snakeMoveManager.move(prey, userDirection);
                generateNextPrey(eaten);
                if (eaten != null && eaten) System.out.println("Snake ate prey, next at" + prey);
                if (eaten != null) {
                    counter++;
                }
            }
        } else {
            Boolean eaten = snakeMoveManager.move(prey);
            generateNextPrey(eaten);
            if (eaten) System.out.println("Snake ate prey, next at" + prey);
        }
        print(snake);
    }

    private void generateNextPrey(Boolean eaten) {
        if (eaten != null && !eaten) return;
        Coordinates nextPrey;
        while (true) {
            int x = random.nextInt(getGameBoundary().getMaxWidth());
            int y = random.nextInt(getGameBoundary().getMaxHeight());
            if (x == prey.getX() && y == prey.getY()) continue;

            nextPrey = new Coordinates(x, y);
            if (snake.occupiedCoordinate(nextPrey)) continue;
            break;
        }
        prey = nextPrey;
    }

    public void setPrey(Coordinates prey) {
        this.prey = prey;
    }

    public IGameBoundary getGameBoundary() {
        return gameBoundary;
    }

    private void testGame() throws SnakeBiteEvent, SnakeBoundaryHitEvent, InterruptedException {

        while (true) {
            nextState();
            player.play(InputDirection.LEFT);

            nextState();
            nextState();
            nextState();
            player.play(InputDirection.UP);
            Thread.sleep(500);

            nextState();
            nextState();
            nextState();
            Thread.sleep(500);
            player.play(InputDirection.DOWN);
            player.play(InputDirection.UP);
            player.play(InputDirection.RIGHT);
            nextState();
            player.play(InputDirection.DOWN);

            Thread.sleep(500);
            nextState();

            Thread.sleep(2000);
        }
    }

    public void print(Snake snake) {
        System.out.println("Snake Head at" + snake.getSnakeHead() + " to " + snake.getSnakeTail() + " Going " + snake.getLastDirection().name());
    }
}
