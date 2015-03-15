package com.coderskitchen.rpsgame;

import java.util.Arrays;
import java.util.List;

import static com.coderskitchen.rpsgame.RPSGestures.*;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorRule {
    private static final List<String> KNOWN_GESTURES = Arrays.asList(ROCK, PAPER, SCISSOR);

    public RockPaperScissorRule() {
    }

    public void apply(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer, RuleOutcomeCallback ruleOutcomeCallback) {
        verifyInputParameter(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer, ruleOutcomeCallback);

        if (gesturesAreTheSame(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer)) {
            ruleOutcomeCallback.tie();
        } else {
            String winningGestureForSecondPlayer = "";
            switch (gestureChosenByFirstPlayer) {
                case ROCK:
                    winningGestureForSecondPlayer = SCISSOR;
                    break;
                case PAPER:
                    winningGestureForSecondPlayer = ROCK;
                    break;
                case SCISSOR:
                    winningGestureForSecondPlayer = PAPER;
                    break;
            }
            decideWhoWins(winningGestureForSecondPlayer, gestureChosenBySecondPlayer, ruleOutcomeCallback);
        }
    }

    private void verifyInputParameter(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer, RuleOutcomeCallback ruleOutcomeCallback) {
        assert KNOWN_GESTURES.contains(gestureChosenByFirstPlayer) : "Gesture " + gestureChosenByFirstPlayer + " chosen by first player unknown";
        assert KNOWN_GESTURES.contains(gestureChosenBySecondPlayer) : "Gesture " + gestureChosenBySecondPlayer + " chosen by second player unknown";
        assert ruleOutcomeCallback != null : "ResultCallback must be set";
    }

    private boolean gesturesAreTheSame(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer) {
        return gestureChosenByFirstPlayer.equalsIgnoreCase(gestureChosenBySecondPlayer);
    }

    private void decideWhoWins(String winningGesture, String gestureChosenBySecondPlayer, RuleOutcomeCallback ruleOutcomeCallback) {
        if (gesturesAreTheSame(winningGesture, gestureChosenBySecondPlayer)) {
            ruleOutcomeCallback.secondPlayerWins();
        } else {
            ruleOutcomeCallback.firstPlayerWins();
        }
    }
}
