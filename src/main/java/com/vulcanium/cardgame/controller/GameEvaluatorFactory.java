package com.vulcanium.cardgame.controller;

public class GameEvaluatorFactory {

    public enum GameEvaluatorType {
        High, // The highest card wins
        Low // The lowest card wins
    }

    public static GameEvaluator makeGameEvaluator(GameEvaluatorType gameEvaluatorType) {

        return switch (gameEvaluatorType) {
            case High -> new HighCardGameEvaluator();
            case Low -> new LowCardGameEvaluator();
        };
    }
}
