package com.vulcanium.cardgame.controller;

import com.vulcanium.cardgame.games.GameEvaluator;
import com.vulcanium.cardgame.model.Deck;
import com.vulcanium.cardgame.model.Player;
import com.vulcanium.cardgame.model.PlayingCard;
import com.vulcanium.cardgame.view.GameViewable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController {

    private enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed
    }

    private final GameViewable view;
    private final Deck deck;
    private final List<Player> players;
    private Player winner;

    private GameState gameState;
    private final GameEvaluator gameEvaluator;

    public GameController(Deck deck, GameViewable view, GameEvaluator gameEvaluator) {
        this.view = view;
        this.deck = deck;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        view.setGameController(this);
        this.gameEvaluator = gameEvaluator;
    }

    public void run() {
        while (gameState == GameState.AddingPlayers) {
            view.promptForPlayerName();
        }

        switch (gameState) {
            case CardsDealt -> view.promptForFlip();
            case WinnerRevealed -> view.promptForNewGame();
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }

    public void startGame() {
        if (gameState != GameState.CardsDealt) {
            deck.shuffle();

            int playerIndex = 1;
            for (Player player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }

            gameState = GameState.CardsDealt;
        }

        this.run();
    }

    public void flipCards() {
        int playerIndex = 1;
        for (Player player : players) {
            PlayingCard card = player.getCardFromHand(0);
            card.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), card.getRank().toString(), card.getSuit().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();

        gameState = GameState.WinnerRevealed;

        this.run();
    }

    public void nextAction(String nextChoice) {
        if (Objects.equals(nextChoice, "q")) {
            exitGame();
        } else {
            startGame();
        }
    }

    private void evaluateWinner() {
        winner = gameEvaluator.evaluateWinner(players);
    }

    private void displayWinner() {
        view.showWinner(winner.getName());
    }

    private void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCardFromHand());
        }
    }

    private void exitGame() {
        System.exit(0);
    }
}