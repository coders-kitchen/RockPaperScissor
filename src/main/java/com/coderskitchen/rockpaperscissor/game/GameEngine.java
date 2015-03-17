package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.player.Gesture;
import com.coderskitchen.rockpaperscissor.game.player.Player;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameEngine {

    private final Rule rule;

    public GameEngine(Rule rule) {
        this.rule = rule;
    }

    public ResultSheet playGame(Settings settings) {
        Integer numberOfRoundsLeft = settings.getNumberOfRoundsToPlay();

        Player firstPlayer = settings.getFirstPlayer();
        Player secondPlayer = settings.getSecondPlayer();

        ResultSheet resultSheet = new ResultSheet();

        while (numberOfRoundsLeft > 0) {
            RoundOutcome roundOutcome = playRound(firstPlayer, secondPlayer);
            resultSheet.applyRoundOutcome(roundOutcome);
            numberOfRoundsLeft--;
        }
        return resultSheet;
    }

    private RoundOutcome playRound(Player firstPlayer, Player secondPlayer) {
        Gesture gestureChosenByFirstPlayer = firstPlayer.chooseGesture();
        Gesture gestureChosenBySecondPlayer = secondPlayer.chooseGesture();

        return  rule.calculateRoundOutcome(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer);
    }
}
