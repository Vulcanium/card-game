package com.vulcanium.cardgame.model;

public class Player {
    private final String name;
    private final Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void addCardToHand(PlayingCard card) {
        hand.addCard(card);
    }

    public PlayingCard getCardFromHand(int index) {
        return hand.getCard(index);
    }

    public PlayingCard removeCardFromHand() {
        return hand.removeCard();
    }
}
