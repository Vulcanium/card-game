package com.vulcanium.cardgame.games;

import com.vulcanium.cardgame.model.Player;
import com.vulcanium.cardgame.model.PlayingCard;

import java.util.List;

public class HighCardGameEvaluator implements GameEvaluator {

    @Override
    public Player evaluateWinner(List<Player> players) {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard card = player.getCardFromHand(0);
                int thisRank = card.getRank().getValue();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (card.getSuit().getValue() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard card = player.getCardFromHand(0);
                bestRank = card.getRank().getValue();
                bestSuit = card.getSuit().getValue();
            }
        }

        return bestPlayer;
    }
}
