package com.vulcanium.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public PlayingCard getCard(int index) {
        return cards.get(index);
    }

    public PlayingCard removeCard() {
        return cards.removeFirst();
    }
}
