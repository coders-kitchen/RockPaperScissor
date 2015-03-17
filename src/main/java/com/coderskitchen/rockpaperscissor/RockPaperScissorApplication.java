package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.*;
import com.coderskitchen.rockpaperscissor.game.GameResultSheet;
import com.coderskitchen.rockpaperscissor.player.Gesture;
import com.coderskitchen.rockpaperscissor.game.GameSettings;
import com.coderskitchen.rockpaperscissor.player.Player;
import com.coderskitchen.rockpaperscissor.player.RandomGestureChoosingStrategy;
import com.coderskitchen.rockpaperscissor.game.GameRule;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorApplication {

    public static final int NUMBER_OF_ROUNDS = 100;
    public static final String PAPER_ONLY_PLAYER_NAME = "PAPER ONLY";
    public static final String RANDOM_GESTURE_PLAYER_NAME = "RANDOM";

    private GameSettings gameSettings;
    private GameEngine gameEngine;
    private GameResultDisplayController gameResultDisplayController;

    public static void main(String[] args) {
        RockPaperScissorApplication rockPaperScissorApplication = new RockPaperScissorApplication();
        rockPaperScissorApplication.setup();
        rockPaperScissorApplication.runGameAndDisplayResults();
    }

    public void setup() {
        gameEngine = new GameEngine(new GameRule());
        gameResultDisplayController = new GameResultDisplayController();
        gameSettings = buildGameSettings();
    }

    private GameSettings buildGameSettings() {
        Player firstPlayer = buildPaperOnlyPlayer();
        Player secondPlayer = buildRandomGesturePlayer();
        return new GameSettings(NUMBER_OF_ROUNDS, firstPlayer, secondPlayer);
    }

    private static Player buildPaperOnlyPlayer() {
        return new Player(PAPER_ONLY_PLAYER_NAME, () -> Gesture.PAPER);
    }

    private static Player buildRandomGesturePlayer() {
        return new Player(RANDOM_GESTURE_PLAYER_NAME, new RandomGestureChoosingStrategy());
    }

    public void runGameAndDisplayResults() {
        GameResultSheet gameResultSheet = gameEngine.playGame(gameSettings);
        gameResultDisplayController.displayResults(gameSettings, gameResultSheet);
    }
}
