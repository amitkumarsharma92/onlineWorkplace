package com.mygame.connect.components;

import com.mygame.connect.Player;

public class Board {
    private static Board gameBoard = new Board();
    protected Coin[][] gameState;
    protected RuleManager ruleManager;
    public static int ROW_COUNT = 6;
    public static int COLUMN_COUNT = 7;
    public static int STREAK_COUNT = 7;

    private Board() {
        super();
        this.gameState = new Coin[ROW_COUNT][COLUMN_COUNT];
        this.ruleManager = new RuleManager();
    }

    public static Board getInstance() {
        return gameBoard;
    }

    public MoveEvent registerMove(MoveEvent event)  {
        Player player = event.getPlayer();
        Integer moveColumn = event.getMoveColumn();
        Coin coin = player.getCoin();

        if (gameState[ROW_COUNT - 1][moveColumn] != null) {
            event.setInvalidMove(true);
        } else {
            for (int row = 0; row < ROW_COUNT; row++) {
                if (gameState[row][moveColumn] == null) {
                    gameState[row][moveColumn] = coin;
                    event.setMoveRow(row);
                    event.setGameState(this.getGameState());
                }
            }
        }
        return event;
    }

    //    public void checkGameCompleted(Player player, int moveColumn, int moveRow) {
//        ruleManager.checkGameCompleted(player, this, moveColumn, moveRow);
//    }
    public Coin[][] getGameState() {
        return gameState;
    }
}
