package com.vulcanium.cardgame;

import com.vulcanium.cardgame.controller.GameController;
import com.vulcanium.cardgame.games.HighCardGameEvaluator;
import com.vulcanium.cardgame.model.Deck;
import com.vulcanium.cardgame.view.CommandLineView;

public class Games {
    public static void main(String[] args) {

        // Games with terminal display
        GameController gameController = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
        //GameController gameController = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());

        // Games with Swing display
        //GameController gameController = new GameController(new Deck(), new SwingView(), new HighCardGameEvaluator());
        //GameController gameController = new GameController(new Deck(), new SwingView(), new LowCardGameEvaluator());

        gameController.run();
    }
}
