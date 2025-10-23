package com.vulcanium.cardgame.games;

import com.vulcanium.cardgame.controller.GameController;
import com.vulcanium.cardgame.model.Deck;
import com.vulcanium.cardgame.view.GameView;

public class Games {
    public static void main(String[] args) {
        GameController gameController = new GameController(new GameView(), new Deck());
        gameController.run();
    }
}
