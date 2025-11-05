package com.vulcanium.cardgame.model;

import java.util.ArrayList;

public class SmallDeck extends Deck {

    public SmallDeck() {
        cards = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                if (rank.getValue() >= 7) {
                    System.out.println("Creating card [" + rank + "][" + suit + "]");
                    cards.add(new Card(rank, suit));
                }
            }
        }

        shuffle();
    }
}
