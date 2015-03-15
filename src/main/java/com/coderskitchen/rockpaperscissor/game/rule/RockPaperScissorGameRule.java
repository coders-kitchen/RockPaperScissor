package com.coderskitchen.rockpaperscissor.game.rule;

import com.coderskitchen.rockpaperscissor.game.domain.RoundOutcome;

import java.util.Arrays;
import java.util.List;

import static com.coderskitchen.rockpaperscissor.game.gesture.RPSGestures.*;

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
                winningGestureForSecondPlayer = PAPER;
                break;
            case PAPER:
                winningGestureForSecondPlayer = SCISSOR;
                break;
            case SCISSOR:
                winningGestureForSecondPlayer = ROCK;
                break;
        }
        return winningGestureForSecondPlayer;
    }

    private void verifyInputParameter(String gestureChosenByFirstPlayer, String gestureChosenBySecondPlayer) {
        assert KNOWN_GESTURES.contains(gestureChosenByFirstPlayer) : "Gesture " + gestureChosenByFirstPlayer + " chosen by first gesture unknown";
        assert KNOWN_GESTURES.contains(gestureChosenBySecondPlayer) : "Gesture " + gestureChosenBySecondPlayer + " chosen by second gesture unknown";
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
