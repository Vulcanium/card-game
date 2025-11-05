package com.vulcanium.cardgame.model;

import lombok.Getter;

public class Player implements IPlayer {
    @Getter
    private final String name;
    private final Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    @Override
    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    @Override
    public Card getCardFromHand(int index) {
        return hand.getCard(index);
    }

    @Override
    public Card removeCardFromHand() {
        return hand.removeCard();
    }
}
