package com.mygame.connect;

import com.mygame.connect.components.Board;
import com.mygame.connect.components.Coin;
import com.mygame.connect.components.MoveEvent;
import com.mygame.connect.components.RuleManager;

import java.awt.*;

public class ConnectFourApp {
    public static void main(String[] args) {
        RuleManager ruleManager = new RuleManager();
        Player player = new Player("Player1", Coin.RED);
        Board gameBoard = Board.getInstance();
        Player computerPlayer = new Player("AI", Coin.YELLOW);
        MoveEvent event = player.playMove(3);

        gameBoard.registerMove(event);
        ruleManager.checkGameCompleted(event);
        if (event.isInvalidMove()){
            System.out.println("Player played Invalid Move. play again");
        }else if(event.isEndState()){
            return;
        }
    }
}
