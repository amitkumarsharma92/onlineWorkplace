package com.battle.game.strategy;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.io.InputProvider;
import com.battle.game.models.Player;
import com.battle.game.models.PlayerChanceTarget;
import com.battle.game.models.PlayerInput;

import java.util.List;

public class LocalChanceGenerationStrategy implements ChanceGenerationStrategy {

    private final InputProvider inputProvider;

    public LocalChanceGenerationStrategy(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public PlayerChanceTarget getPlayerTarget(List<Player> allPlayers) throws InvalidInputException {
        PlayerInput input = inputProvider.takeInput();
        return new PlayerChanceTarget(allPlayers.get(input.getPlayerNum()), input.getCoordinate());
    }
}
