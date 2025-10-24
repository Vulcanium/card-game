package com.vulcanium.cardgame.games;

import com.vulcanium.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    public IPlayer evaluateWinner(List<IPlayer> players);
}