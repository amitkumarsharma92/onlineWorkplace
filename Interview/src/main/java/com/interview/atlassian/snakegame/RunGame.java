package com.interview.atlassian.snakegame;

import com.interview.atlassian.snakegame.board.Coordinates;
import com.interview.atlassian.snakegame.board.GameState;
import com.interview.atlassian.snakegame.board.IGameBoundary;
import com.interview.atlassian.snakegame.board.RectangleGameBoundary;
import com.interview.atlassian.snakegame.board.items.Snake;
import com.interview.atlassian.snakegame.strategy.BoundaryStrategy;
import com.interview.atlassian.snakegame.strategy.RectangularRotationalBoundaryStrategy;

public class RunGame {

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        int boardheight = 10;
        int boardWidth = 10;
        Snake snake = new Snake(InputDirection.UP, new Coordinates(boardheight / 2, boardWidth / 2));
        IGameBoundary gameBoundary = new RectangleGameBoundary(new Coordinates(0, 0),
                boardheight, boardWidth);

        BoundaryStrategy strategy = new RectangularRotationalBoundaryStrategy();
        GameState gameState = new GameState(new Player("player1"), gameBoundary,
                new SnakeMoveManager(snake, strategy));
        gameState.setPrey(new Coordinates(4,2));

        gameState.gameLoop();
    }


}
