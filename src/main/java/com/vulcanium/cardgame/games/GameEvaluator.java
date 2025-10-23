package com.vulcanium.cardgame.games;

import com.vulcanium.cardgame.model.Player;
import com.vulcanium.cardgame.model.PlayingCard;

import java.util.List;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> players);
}