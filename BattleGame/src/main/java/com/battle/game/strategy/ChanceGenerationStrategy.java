package com.battle.game.strategy;

import com.battle.game.exceptions.InvalidInputException;
import com.battle.game.models.Player;
import com.battle.game.models.PlayerChanceTarget;

import java.util.List;

public interface ChanceGenerationStrategy {

    PlayerChanceTarget getPlayerTarget(List<Player> allPlayers) throws InvalidInputException;
}
