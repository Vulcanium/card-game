package com.vulcanium.cardgame.view;

import com.vulcanium.cardgame.controller.GameController;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class GameView {
    @Setter
    private GameController gameController;
    private final Scanner keyboard = new Scanner(System.in);

    public void promptForPlayerName() {
        System.out.println("Enter player name: ");
        String playerName = keyboard.nextLine();

        if (StringUtils.isBlank(playerName)) {
            gameController.startGame();
        } else {
            gameController.addPlayer(playerName);
        }
    }

    public void promptForFlip() {
        System.out.println("Press enter to reveal card");
        keyboard.nextLine();
        gameController.flipCards();
    }

    public void promptForNewGame() {
        System.out.println("Press enter to deal again");
        keyboard.nextLine();
        gameController.startGame();
    }

    public void showPlayerName(int playerIndex, String playerName) {
        System.out.println("[" + playerIndex + "][" + playerName + "]");
    }

    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        System.out.println("[" + playerIndex + "][" + playerName + "][x][x]");
    }

    public void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit) {
        System.out.println("[" + playerIndex + "][" + playerName + "][" + cardRank + "][" + cardSuit + "]");
    }

    public void showWinner(String playerName) {
        System.out.println("The winner is: " + playerName + " !");
    }
}
