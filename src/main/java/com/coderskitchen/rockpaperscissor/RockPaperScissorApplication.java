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
    public static final String PAPER_ONLY_PLAYER_NAME = "A";
    public static final String RANDOM_GESTURE_PLAYER_NAME = "B";

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
        gameSettings = buildGameSettings(NUMBER_OF_ROUNDS);
    }

    private GameSettings buildGameSettings(int numberOfRoundsToPlay) {
        Player firstPlayer = buildPaperOnlyPlayer(PAPER_ONLY_PLAYER_NAME);
        Player secondPlayer = buildRandomGesturePlayer(RANDOM_GESTURE_PLAYER_NAME);
        return new GameSettings(numberOfRoundsToPlay, firstPlayer, secondPlayer);
    }

    private static Player buildPaperOnlyPlayer(String playerName) {
        return new Player(playerName, () -> Gesture.PAPER);
    }

    private static Player buildRandomGesturePlayer(String playerName) {
        return new Player(playerName, new RandomGestureChoosingStrategy());
    }

    public void runGameAndDisplayResults() {
        GameResultSheet gameResultSheet = gameEngine.playGame(gameSettings);
        gameResultDisplayController.displayResults(gameSettings, gameResultSheet);
    }
}
