package com.vulcanium.cardgame.model;

import java.util.ArrayList;

public class NormalDeck extends Deck {

    public NormalDeck() {
        cards = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println("Creating card [" + rank + "][" + suit + "]");
                cards.add(new Card(rank, suit));
            }
        }

        shuffle();
    }
}
