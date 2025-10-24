package com.vulcanium.cardgame.view;

import com.vulcanium.cardgame.controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class GameViewables implements GameViewable {
    List<GameViewable> views;

    public GameViewables() {
        views = new ArrayList<>();
    }

    public void addViewable(GameViewable view) {
        views.add(view);
    }

    @Override
    public void setGameController(GameController gameController) {
        for (GameViewable view : views) {
            view.setGameController(gameController);
        }
    }

    @Override
    public void promptForPlayerName() {
        for (GameViewable view : views) {
            view.promptForPlayerName();
        }
    }

    @Override
    public void promptForFlip() {
        for (GameViewable view : views) {
            view.promptForFlip();
        }
    }

    @Override
    public void promptForNewGame() {
        for (GameViewable view : views) {
            view.promptForNewGame();
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        for (GameViewable view : views) {
            view.showPlayerName(playerIndex, playerName);
        }
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        for (GameViewable view : views) {
            view.showFaceDownCardForPlayer(playerIndex, playerName);
        }
    }

    @Override
    public void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit) {
        for (GameViewable view : views) {
            view.showCardForPlayer(playerIndex, playerName, cardRank, cardSuit);
        }
    }

    @Override
    public void showWinner(String playerName) {
        for (GameViewable view : views) {
            view.showWinner(playerName);
        }
    }
}
