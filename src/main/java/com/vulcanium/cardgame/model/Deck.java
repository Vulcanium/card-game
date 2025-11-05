package com.vulcanium.cardgame.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck {
    protected List<Card> cards;

    public void shuffle() {
        Random random = new Random();

        for (int i = 0; i < cards.size(); i++) {
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }

    public Card removeTopCard() {
        return cards.removeFirst();
    }

    public void returnCardToDeck(Card card) {
        cards.add(card);
    }
}
