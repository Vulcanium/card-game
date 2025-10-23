package com.vulcanium.cardgame.controller;

import com.vulcanium.cardgame.model.Deck;
import com.vulcanium.cardgame.model.Player;
import com.vulcanium.cardgame.model.PlayingCard;
import com.vulcanium.cardgame.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed;
    }

    private GameView view;
    private Deck deck;
    private List<Player> players;
    private Player winner;

    private GameState gameState;

    public GameController(GameView view, Deck deck) {
        this.view = view;
        this.deck = deck;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        view.setGameController(this);
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

    private void evaluateWinner() {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard card = player.getCardFromHand(0);
                int thisRank = card.getRank().getValue();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (card.getSuit().getValue() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard card = player.getCardFromHand(0);
                bestRank = card.getRank().getValue();
                bestSuit = card.getSuit().getValue();
            }
        }

        winner = bestPlayer;
    }

    private void displayWinner() {
        view.showWinner(winner.getName());
    }

    private void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCardFromHand());
        }
    }
}