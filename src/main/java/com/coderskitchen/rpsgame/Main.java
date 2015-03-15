package com.coderskitchen.rpsgame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Peter on 15.03.2015.
 */
public class Main {

    public static final int NUMBER_OF_ROUNDS = 100;
    public static final String PAPER_ONLY_PLAYER_NAME = "A";
    public static final String RANDOM_GESTURE_PLAYER_NAME = "B";

    public static void main(String[] args) {

        RockPaperScissorGameSettings rockPaperScissorGameSettings = buildGameSettings(NUMBER_OF_ROUNDS);
        GameResultSheet gameResultSheet = new GameResultSheet();

        RuleOutcomeCallbackImpl gameRoundResultCallback = new RuleOutcomeCallbackImpl(gameResultSheet);

        RockPaperScissorGameController rockPaperScissorGameController = new RockPaperScissorGameController();
        rockPaperScissorGameController.play(rockPaperScissorGameSettings, gameRoundResultCallback);
        rockPaperScissorGameController.displayResults(rockPaperScissorGameSettings, gameResultSheet);
    }

    private static RockPaperScissorGameSettings buildGameSettings(int numberOfRoundsToPlay) {
        Player firstPlayer = buildPaperOnlyPlayer(PAPER_ONLY_PLAYER_NAME);
        Player secondPlayer = buildRandomGesturePlayer(RANDOM_GESTURE_PLAYER_NAME);
        return new RockPaperScissorGameSettings(numberOfRoundsToPlay, firstPlayer, secondPlayer, new RockPaperScissorRule());
    }

    private static Player buildPaperOnlyPlayer(String playerName) {
        return new Player(playerName, () -> RPSGestures.PAPER);
    }

    private static Player buildRandomGesturePlayer(String playerName) {
        return new Player(playerName, () -> {
            List<String> gestures = Arrays.asList(RPSGestures.ROCK, RPSGestures.PAPER, RPSGestures.SCISSOR);
            Collections.shuffle(gestures);
            return gestures.get(0);
        });
    }
}
