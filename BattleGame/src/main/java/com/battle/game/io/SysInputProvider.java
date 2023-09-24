package com.battle.game.io;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.PlayerInput;
import com.battle.game.models.board.Coordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SysInputProvider implements InputProvider {

    @Override
    public PlayerInput takeInput() throws InvalidInputException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int playernum = getInt(reader, "Y");
        int x = getInt(reader, "X");
        int y = getInt(reader, "Y");
        return new PlayerInput(new Coordinate(x, y), playernum);
    }

    private int getInt(BufferedReader reader, String coor) throws InvalidInputException {
        while (true) {
            try {
                System.out.println("Enter value for " + coor + " : ");
                String xCoord = reader.readLine();
                int x = Integer.parseInt(xCoord);
                return x;
            } catch (IOException | NumberFormatException e) {
                throw new InvalidInputException();
            }
        }
    }


}
