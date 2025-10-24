package com.vulcanium.cardgame.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WinningPlayer implements IPlayer {
    private IPlayer winner;

    @Override
    public String getName() {
        return "***** " + winner.getName() + " *****";
    }

    @Override
    public void addCardToHand(PlayingCard card) {
        winner.addCardToHand(card);
    }

    @Override
    public PlayingCard getCardFromHand(int index) {
        return winner.getCardFromHand(index);
    }

    @Override
    public PlayingCard removeCardFromHand() {
        return winner.removeCardFromHand();
    }
}
