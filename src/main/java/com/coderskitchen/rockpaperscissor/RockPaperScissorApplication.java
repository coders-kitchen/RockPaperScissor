package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.*;
import com.coderskitchen.rockpaperscissor.game.ResultSheet;
import com.coderskitchen.rockpaperscissor.player.Gesture;
import com.coderskitchen.rockpaperscissor.game.Settings;
import com.coderskitchen.rockpaperscissor.player.Player;
import com.coderskitchen.rockpaperscissor.player.RandomGestureChoosingStrategy;
import com.coderskitchen.rockpaperscissor.game.Rule;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorApplication {

    public static final int NUMBER_OF_ROUNDS = 100;
    public static final String PAPER_ONLY_PLAYER_NAME = "PAPER ONLY";
    public static final String RANDOM_GESTURE_PLAYER_NAME = "RANDOM";

    private Settings settings;
    private GameEngine gameEngine;
    private ResultDisplayController resultDisplayController;

    public static void main(String[] args) {
        RockPaperScissorApplication rockPaperScissorApplication = new RockPaperScissorApplication();
        rockPaperScissorApplication.setup();
        rockPaperScissorApplication.runGameAndDisplayResults();
    }

    public void setup() {
        gameEngine = new GameEngine(new Rule());
        resultDisplayController = new ResultDisplayController();
        settings = buildGameSettings();
    }

    private Settings buildGameSettings() {
        Player firstPlayer = buildPaperOnlyPlayer();
        Player secondPlayer = buildRandomGesturePlayer();
        return new Settings(NUMBER_OF_ROUNDS, firstPlayer, secondPlayer);
    }

    private static Player buildPaperOnlyPlayer() {
        return new Player(PAPER_ONLY_PLAYER_NAME, () -> Gesture.PAPER);
    }

    private static Player buildRandomGesturePlayer() {
        return new Player(RANDOM_GESTURE_PLAYER_NAME, new RandomGestureChoosingStrategy());
    }

    public void runGameAndDisplayResults() {
        ResultSheet resultSheet = gameEngine.playGame(settings);
        resultDisplayController.displayResults(settings, resultSheet);
    }
}
