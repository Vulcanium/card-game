package com.vulcanium.cardgame;

import com.vulcanium.cardgame.controller.GameController;
import com.vulcanium.cardgame.controller.GameEvaluatorFactory;
import com.vulcanium.cardgame.controller.GameEvaluatorFactory.GameEvaluatorType;
import com.vulcanium.cardgame.model.DeckFactory;
import com.vulcanium.cardgame.model.DeckFactory.DeckType;
import com.vulcanium.cardgame.view.GameViewables;
import com.vulcanium.cardgame.view.SwingPassiveView;
import com.vulcanium.cardgame.view.SwingView;

public class Games {
    public static void main(String[] args) {

        // Games with terminal display
        //GameController gameController = new GameController(DeckFactory.makeDeck(DeckType.Small), new CommandLineView(), GameEvaluatorFactory.makeGameEvaluator(GameEvaluatorType.Low));
        //gameController.run();

        // Games with Swing display
        //GameController gameController = new GameController(DeckFactory.makeDeck(DeckType.Normal), new SwingView(), GameEvaluatorFactory.makeGameEvaluator(GameEvaluatorType.High));
        //gameController.run();

        // Games with multiple Swing display
        GameViewables views = new GameViewables();
        views.addViewable(new SwingView());

        for (int i = 0; i < 3; i++) {
            views.addViewable(new SwingPassiveView());

            // sleep to move new Swing frame on window
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        GameController gameController = new GameController(DeckFactory.makeDeck(DeckType.Normal), views, GameEvaluatorFactory.makeGameEvaluator(GameEvaluatorType.High));

        gameController.run();
    }
}
