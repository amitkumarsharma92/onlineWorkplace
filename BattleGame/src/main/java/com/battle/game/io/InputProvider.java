package com.battle.game.io;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.PlayerInput;

public interface InputProvider {
    public PlayerInput takeInput() throws InvalidInputException
}
