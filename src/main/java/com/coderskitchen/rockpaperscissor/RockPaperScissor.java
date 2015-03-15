package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.*;
import com.coderskitchen.rockpaperscissor.game.domain.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.gesture.RPSGestures;
import com.coderskitchen.rockpaperscissor.game.domain.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.domain.Player;
import com.coderskitchen.rockpaperscissor.game.gesture.RandomGestureChoosingStrategy;
import com.coderskitchen.rockpaperscissor.game.rule.RockPaperScissorGameRule;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissor {

    public static final int NUMBER_OF_ROUNDS = 100;
    public static final String PAPER_ONLY_PLAYER_NAME = "A";
    public static final String RANDOM_GESTURE_PLAYER_NAME = "B";
    private RockPaperScissorGameSettings rockPaperScissorGameSettings;
    private RockPaperScissorGameController rockPaperScissorGameController;
    private ResultDisplayController resultDisplayController;

    public static void main(String[] args) {
        RockPaperScissor rockPaperScissor = new RockPaperScissor();
        rockPaperScissor.setup();
        rockPaperScissor.runGameAndDisplayResults();
    }

    public void setup() {
        rockPaperScissorGameController = new RockPaperScissorGameController();
        resultDisplayController = new ResultDisplayController();
        RockPaperScissorGameRule rockPaperScissorGameRule = new RockPaperScissorGameRule();
        rockPaperScissorGameSettings = buildGameSettings(NUMBER_OF_ROUNDS, rockPaperScissorGameRule);
    }

    private static RockPaperScissorGameSettings buildGameSettings(int numberOfRoundsToPlay, RockPaperScissorGameRule rockPaperScissorGameRule) {
        Player firstPlayer = buildPaperOnlyPlayer(PAPER_ONLY_PLAYER_NAME);
        Player secondPlayer = buildRandomGesturePlayer(RANDOM_GESTURE_PLAYER_NAME);
        return new RockPaperScissorGameSettings(numberOfRoundsToPlay, firstPlayer, secondPlayer, rockPaperScissorGameRule);
    }

    private static Player buildPaperOnlyPlayer(String playerName) {
        return new Player(playerName, () -> RPSGestures.PAPER);
    }

    private static Player buildRandomGesturePlayer(String playerName) {
        return new Player(playerName, new RandomGestureChoosingStrategy());
    }

    public void runGameAndDisplayResults() {
        GameResultSheet gameResultSheet = rockPaperScissorGameController.playGame(rockPaperScissorGameSettings, new GameResultSheet());
        resultDisplayController.displayResults(rockPaperScissorGameSettings, gameResultSheet);
    }
}
