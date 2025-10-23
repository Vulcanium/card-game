package com.vulcanium.cardgame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Suit {
    JOKER(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3),
    CLUBS(4);

    private final int value;
}
