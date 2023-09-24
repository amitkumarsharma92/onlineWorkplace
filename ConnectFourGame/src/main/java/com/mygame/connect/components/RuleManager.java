package com.mygame.connect.components;

import com.mygame.connect.Player;

public class RuleManager {
    public RuleManager() {
        super();
    }

    public void checkGameCompleted(MoveEvent event) {
        if (checkDownStreak(event)
                || checkLeftStreak(event)
                || checkRightStreak(event)
                || checkLeftInclinedStreak(event)
                || checkRightInclinedStreak(event)) {
            declareWinner(event);
        }
    }

    /**
     * Right [x][->][->][->] side Column traversal for 3 columns, all should be same
     *
     * @param event
     * @return
     */
    private boolean checkRightStreak(MoveEvent event) {
        if (checkRightBound(event)) {
            return false;
        }
        Coin coin = event.getPlayer().getCoin();
        Coin[][] gameState = event.getGameState();
        int moveColumn = event.getMoveColumn();
        int moveRow = event.getMoveRow();
        for (int i =  1; i <=  3; i++) {
            if (gameState[moveRow][moveColumn + i] != coin) {
                return false;
            }
        }
        return true;
    }

    /**
     * Left [<-][<-][<-][x] side Column traversal for 3 columns, all should be same
     *
     * @param event
     * @return
     */
    private boolean checkLeftStreak(MoveEvent event) {
        if (checkLeftBound(event)) {
            return false;
        }
        Coin coin = event.getPlayer().getCoin();
        Coin[][] gameState = event.getGameState();
        int moveColumn = event.getMoveColumn();
        int moveRow = event.getMoveRow();
        for (int i =  1; i <=  3; i++) {
            if (gameState[moveRow][moveColumn - i] != coin) {
                return false;
            }
        }
        return true;
    }

    /**
     * Right [ ][  ][  ][->] side Column traversal in inclinefor 3 columns, all should be same
     * [ ][  ][->]
     * [ ][->]
     * [X]
     * [ ][->]
     * [ ][  ][->]
     * [ ][  ][  ][->]
     *
     * @param event
     * @return
     */
    private boolean checkRightInclinedStreak(MoveEvent event) {
        if (checkRightBound(event)) {
            return false;
        }
        Coin coin = event.getPlayer().getCoin();
        Coin[][] gameState = event.getGameState();
        int moveColumn = event.getMoveColumn();
        int moveRow = event.getMoveRow();
        if (checkDownBound(event)) {
            for (int i =  1; i <=  3; i++) {
                if (gameState[moveRow - i][moveColumn + i] != coin) {
                    return false;
                }
            }
        } else {
            for (int i =  1; i <=  3; i++) {
                if (gameState[moveRow + i][moveColumn + i] != coin) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * [  ][  ][  ][x] Lefy side Inclined Column traversal in inclinefor 3 columns, all should be same
     * [  ][  ][<-]
     * [  ][<-]
     * [<-]
     * [  ][<-]
     * [  ][  ][<-]
     * [  ][  ][  ][x]
     *
     * @param event
     * @return
     */
    private boolean checkLeftInclinedStreak(MoveEvent event) {
        if (checkLeftBound(event)) {
            return false;
        }
        Coin coin = event.getPlayer().getCoin();
        Coin[][] gameState = event.getGameState();
        int moveColumn = event.getMoveColumn();
        int moveRow = event.getMoveRow();
        if (checkDownBound(event)) {
            for (int i =  1; i <=  3; i++) {
                if (gameState[moveRow - i][moveColumn - i] != coin) {
                    return false;
                }
            }
        } else {
            for (int i =  1; i <=  3; i++) {
                if (gameState[moveRow + i][moveColumn - i] != coin) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * [x] Down side Column traversal in inclinefor 3 columns, all should be same
     * [|]
     * [|]
     * [|]
     * @param event
     * @return
     */
    private boolean checkDownStreak(MoveEvent event) {
        if (checkDownBound(event)) {
            return false;
        }
        Coin coin = event.getPlayer().getCoin();
        Coin[][] gameState = event.getGameState();
        int moveColumn = event.getMoveColumn();
        int moveRow = event.getMoveRow();
        for (int i =  1; i <=  3; i++) {
            if (gameState[moveRow - i][moveColumn] != coin) {
                return false;
            }
        }
        return true;
    }

    private void declareWinner(MoveEvent event) {
        System.out.println(event.getPlayer() + " won!");
    }

    private boolean checkRightBound(MoveEvent event) {
        return (Board.COLUMN_COUNT - event.getMoveColumn() >= Board.STREAK_COUNT);
    }

    private boolean checkLeftBound(MoveEvent event) {
        return (event.getMoveColumn() >= Board.STREAK_COUNT - 1);
    }

    private boolean checkDownBound(MoveEvent event) {
        return (event.getMoveColumn() < Board.STREAK_COUNT - 1);
    }
}
