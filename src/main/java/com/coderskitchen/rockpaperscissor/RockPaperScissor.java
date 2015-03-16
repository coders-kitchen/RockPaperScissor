package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.*;
import com.coderskitchen.rockpaperscissor.game.model.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.model.Gesture;
import com.coderskitchen.rockpaperscissor.game.model.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.model.Player;
import com.coderskitchen.rockpaperscissor.game.gesture.RandomGestureChoosingStrategy;
import com.coderskitchen.rockpaperscissor.game.RockPaperScissorGameRule;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissor {

    public static final int NUMBER_OF_ROUNDS = 100;
    public static final String PAPER_ONLY_PLAYER_NAME = "A";
    public static final String RANDOM_GESTURE_PLAYER_NAME = "B";

    private RockPaperScissorGameSettings rockPaperScissorGameSettings;
    private RockPaperScissorGameController rockPaperScissorGameController;
    private GameResultDisplayController gameResultDisplayController;

    public static void main(String[] args) {
        RockPaperScissor rockPaperScissor = new RockPaperScissor();
        rockPaperScissor.setup();
        rockPaperScissor.runGameAndDisplayResults();
    }

    public void setup() {
        rockPaperScissorGameController = new RockPaperScissorGameController(new RockPaperScissorGameRule());
        gameResultDisplayController = new GameResultDisplayController();
        rockPaperScissorGameSettings = buildGameSettings(NUMBER_OF_ROUNDS);
    }

    private RockPaperScissorGameSettings buildGameSettings(int numberOfRoundsToPlay) {
        Player firstPlayer = buildPaperOnlyPlayer(PAPER_ONLY_PLAYER_NAME);
        Player secondPlayer = buildRandomGesturePlayer(RANDOM_GESTURE_PLAYER_NAME);
        return new RockPaperScissorGameSettings(numberOfRoundsToPlay, firstPlayer, secondPlayer);
    }

    private static Player buildPaperOnlyPlayer(String playerName) {
        return new Player(playerName, () -> Gesture.PAPER);
    }

    private static Player buildRandomGesturePlayer(String playerName) {
        return new Player(playerName, new RandomGestureChoosingStrategy());
    }

    public void runGameAndDisplayResults() {
        GameResultSheet gameResultSheet = rockPaperScissorGameController.playGame(rockPaperScissorGameSettings);
        gameResultDisplayController.displayResults(rockPaperScissorGameSettings, gameResultSheet);
    }
}
