package com.battle.game;

import com.battle.game.io.SysInputProvider;
import com.battle.game.models.Player;
import com.battle.game.models.board.Board;
import com.battle.game.models.board.BoardItem;
import com.battle.game.models.board.Coordinate;
import com.battle.game.models.board.RectangularBoundary;
import com.battle.game.models.ship.Ship;
import com.battle.game.models.ship.ShipType;
import com.battle.game.strategy.ChanceGenerationStrategy;
import com.battle.game.strategy.LocalChanceGenerationStrategy;
import com.battle.game.strategy.RRPlayerTurnStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/anomaly2104/battleship-game-low-level-design/blob/master/problem-statement.md
 */
public class Main {
    /**
     * Init state
     * * Have 2 Players
     * * Have 5 Ships and a Board
     * Behavior
     * * Rotate Player on some basis
     * * Select opponent Board
     * * Take coordinate Input
     * * Show current player for turn as Output
     * * Check for winner/only alive
     * <p>
     * Busines logic
     * * Ship with all coordicate lost
     * * Player with all 5 lost ship loses out
     * * hit coordinate is either miss or hit
     *
     * @param args
     */
    public static void main(String[] args) {
        ChanceGenerationStrategy chanceGenerationStrategy = new LocalChanceGenerationStrategy(new SysInputProvider());
        List<Player> players = getAllPlayers(chanceGenerationStrategy);

        GameLoop gameLoop = new GameLoop(getPlayerTurnStrategy(players), players);
        gameLoop.start();
    }

    private static RRPlayerTurnStrategy getPlayerTurnStrategy(List<Player> players) {
        return new RRPlayerTurnStrategy(players);
    }

    private static List<Player> getAllPlayers(ChanceGenerationStrategy chanceGenerationStrategy) {
        List<Player> players = new ArrayList<>();
        players.add(getFirstPlayer(chanceGenerationStrategy));
        players.add(getSecondPlayer(chanceGenerationStrategy));
        return players;
    }

    private static Player getFirstPlayer(ChanceGenerationStrategy chanceGenerationStrategy) {
        Ship carrier = new Ship(ShipType.CARRIER, new RectangularBoundary(new Coordinate(2, 0), 5, 1));
        Ship battleship = new Ship(ShipType.BATTLESHIP, new RectangularBoundary(new Coordinate(5, 4), 1, 4));
        Ship cruiser = new Ship(ShipType.CRUISER, new RectangularBoundary(new Coordinate(0, 4), 3, 1));
        Ship submarine = new Ship(ShipType.SUBMARINE, new RectangularBoundary(new Coordinate(4, 7), 1, 3));
        Ship destroyer = new Ship(ShipType.DESTROYER, new RectangularBoundary(new Coordinate(3, 3), 2, 1));

        List<BoardItem> boardItems = new ArrayList<>();
        boardItems.add(carrier);
        boardItems.add(battleship);
        boardItems.add(cruiser);
        boardItems.add(submarine);
        boardItems.add(destroyer);

        Board board = new Board(
                new RectangularBoundary(new Coordinate(0, 0), 10, 10), boardItems);
        return new Player("Player1", board, chanceGenerationStrategy);
    }

    private static Player getSecondPlayer(ChanceGenerationStrategy chanceGenerationStrategy) {
        Ship carrier = new Ship(ShipType.CARRIER, new RectangularBoundary(new Coordinate(4, 4), 1, 5));
        Ship battleship = new Ship(ShipType.BATTLESHIP, new RectangularBoundary(new Coordinate(7, 6), 1, 4));
        Ship cruiser = new Ship(ShipType.CRUISER, new RectangularBoundary(new Coordinate(0, 2), 3, 1));
        Ship submarine = new Ship(ShipType.SUBMARINE, new RectangularBoundary(new Coordinate(2, 6), 1, 3));
        Ship destroyer = new Ship(ShipType.DESTROYER, new RectangularBoundary(new Coordinate(7, 5), 2, 1));

        List<BoardItem> boardItems = new ArrayList<>();
        boardItems.add(carrier);
        boardItems.add(battleship);
        boardItems.add(cruiser);
        boardItems.add(submarine);
        boardItems.add(destroyer);

        Board board = new Board(
                new RectangularBoundary(new Coordinate(0, 0), 10, 10), boardItems);
        return new Player("Player1", board, chanceGenerationStrategy);
    }
}