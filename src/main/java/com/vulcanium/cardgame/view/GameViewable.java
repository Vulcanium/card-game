package com.vulcanium.cardgame.view;

import com.vulcanium.cardgame.controller.GameController;

public interface GameViewable {

    public void setGameController(GameController gameController);

    public void promptForPlayerName();

    public void promptForFlip();

    public void promptForNewGame();

    public void showPlayerName(int playerIndex, String playerName);

    public void showFaceDownCardForPlayer(int playerIndex, String playerName);

    public void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit);

    public void showWinner(String playerName);
}
