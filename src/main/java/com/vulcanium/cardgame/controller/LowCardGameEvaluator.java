package com.vulcanium.cardgame.controller;

import com.vulcanium.cardgame.model.IPlayer;
import com.vulcanium.cardgame.model.Card;

import java.util.List;

public class LowCardGameEvaluator implements GameEvaluator {

    @Override
    public IPlayer evaluateWinner(List<IPlayer> players) {
        IPlayer bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (IPlayer player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                Card card = player.getCardFromHand(0);
                int thisRank = card.getRank().getValue();
                if (thisRank <= bestRank) {
                    if (thisRank < bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (card.getSuit().getValue() < bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                Card card = player.getCardFromHand(0);
                bestRank = card.getRank().getValue();
                bestSuit = card.getSuit().getValue();
            }
        }

        return bestPlayer;
    }
}
