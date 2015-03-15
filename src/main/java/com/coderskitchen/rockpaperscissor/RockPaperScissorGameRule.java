package com.coderskitchen.rockpaperscissor;

import java.util.Arrays;
import java.util.List;

import static com.coderskitchen.rockpaperscissor.RPSGestures.*;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameRule {
    private static final List<String> KNOWN_GESTURES = Arrays.asList(ROCK, PAPER, SCISSOR);

    public RockPaperScissorGameRule() {
    }

    public RoundOutcome calculateRoundOutcome(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer) {
        verifyInputParameter(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer);

        if (gesturesAreTheSame(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer)) {
            return RoundOutcome.TIE;
        }
        String winningGestureForSecondPlayer = determineWhichGestureIsWinningGestureForSecondPlayer(gestureChosenByFirstPlayer);
        return decideWhoWins(winningGestureForSecondPlayer, gestureChosenBySecondPlayer);
    }

    private String determineWhichGestureIsWinningGestureForSecondPlayer(String gestureChosenByFirstPlayer) {
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
        return winningGestureForSecondPlayer;
    }

    private void verifyInputParameter(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer) {
        assert KNOWN_GESTURES.contains(gestureChosenByFirstPlayer) : "Gesture " + gestureChosenByFirstPlayer + " chosen by first player unknown";
        assert KNOWN_GESTURES.contains(gestureChosenBySecondPlayer) : "Gesture " + gestureChosenBySecondPlayer + " chosen by second player unknown";
    }

    private boolean gesturesAreTheSame(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer) {
        return gestureChosenByFirstPlayer.equalsIgnoreCase(gestureChosenBySecondPlayer);
    }

    private RoundOutcome decideWhoWins(String winningGesture, String gestureChosenBySecondPlayer) {
        if (gesturesAreTheSame(winningGesture, gestureChosenBySecondPlayer)) {
            return RoundOutcome.SECOND_PLAYER_WINS;
        } else {
            return RoundOutcome.FIRST_PLAYER_WINS;
        }
    }
}
