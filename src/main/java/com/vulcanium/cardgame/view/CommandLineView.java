package com.vulcanium.cardgame.view;

import com.vulcanium.cardgame.controller.GameController;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class CommandLineView implements GameViewable {
    private GameController gameController;
    private final Scanner keyboard = new Scanner(System.in);

    @Override
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void promptForPlayerName() {
        System.out.println("Enter player name: ");
        String playerName = keyboard.nextLine();

        if (StringUtils.isBlank(playerName)) {
            gameController.startGame();
        } else {
            gameController.addPlayer(playerName);
        }
    }

    @Override
    public void promptForFlip() {
        System.out.println("Press enter to reveal card");
        keyboard.nextLine();
        gameController.flipCards();
    }

    @Override
    public void promptForNewGame() {
        System.out.println("Press enter to deal again or q to exit");
        gameController.nextAction(keyboard.nextLine());
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        System.out.println("[" + playerIndex + "][" + playerName + "]");
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        System.out.println("[" + playerIndex + "][" + playerName + "][x][x]");
    }

    @Override
    public void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit) {
        System.out.println("[" + playerIndex + "][" + playerName + "][" + cardRank + "][" + cardSuit + "]");
    }

    @Override
    public void showWinner(String playerName) {
        System.out.println("The winner is: " + playerName + " !");
    }
}
