package com.vulcanium.cardgame.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayingCard {
    private final Rank rank;
    private final Suit suit;
    private boolean faceUp;

    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }
}
