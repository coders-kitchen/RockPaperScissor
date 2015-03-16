package com.coderskitchen.rockpaperscissor.game.rule;

import com.coderskitchen.rockpaperscissor.game.domain.RoundOutcome;
import com.coderskitchen.rockpaperscissor.game.gesture.Gesture;

import static com.coderskitchen.rockpaperscissor.game.gesture.Gesture.*;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameRule {
    public RockPaperScissorGameRule() {
    }

    public RoundOutcome calculateRoundOutcome(Gesture gestureChosenByFirstPlayer, Gesture gestureChosenBySecondPlayer) {

        if (gesturesAreTheSame(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer)) {
            return RoundOutcome.TIE;
        }
        Gesture winningGestureForSecondPlayer = determineWhichGestureIsWinningGestureForSecondPlayer(gestureChosenByFirstPlayer);
        return decideWhoWins(winningGestureForSecondPlayer, gestureChosenBySecondPlayer);
    }

    private Gesture determineWhichGestureIsWinningGestureForSecondPlayer(Gesture gestureChosenByFirstPlayer) {
        Gesture winningGestureForSecondPlayer = null;
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

    private boolean gesturesAreTheSame(Gesture gestureChosenByFirstPlayer, Gesture gestureChosenBySecondPlayer) {
        return gestureChosenByFirstPlayer == gestureChosenBySecondPlayer;
    }

    private RoundOutcome decideWhoWins(Gesture winningGesture, Gesture gestureChosenBySecondPlayer) {
        if (gesturesAreTheSame(winningGesture, gestureChosenBySecondPlayer)) {
            return RoundOutcome.SECOND_PLAYER_WINS;
        } else {
            return RoundOutcome.FIRST_PLAYER_WINS;
        }
    }
}
