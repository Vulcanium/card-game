package com.vulcanium.cardgame.model;

public class DeckFactory {

    public enum DeckType {
        Normal, // 52 cards
        Small, // 32 cards
        Test // Custom cards for tests
    }

    public static Deck makeDeck(DeckType deckType) {

        return switch (deckType) {
            case Normal -> new NormalDeck();
            case Small -> new SmallDeck();
            case Test -> new TestDeck();
        };
    }
}
