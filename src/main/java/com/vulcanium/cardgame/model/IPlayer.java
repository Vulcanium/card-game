package com.vulcanium.cardgame.model;

public interface IPlayer {
    public String getName();

    public void addCardToHand(Card card);

    public Card getCardFromHand(int index);

    public Card removeCardFromHand();
}
