package com.vulcanium.cardgame.model;

import lombok.Getter;

public interface IPlayer {
    public String getName();

    public void addCardToHand(PlayingCard card);

    public PlayingCard getCardFromHand(int index);

    public PlayingCard removeCardFromHand();
}
