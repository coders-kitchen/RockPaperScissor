package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.player.Gesture;

import static com.coderskitchen.rockpaperscissor.player.Gesture.*;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameRule {

    public RoundOutcome calculateRoundOutcome(Gesture gestureChosenByFirstPlayer, Gesture gestureChosenBySecondPlayer) {

        if (gesturesAreTheSame(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer)) {
            return RoundOutcome.TIE;
        }
        Gesture winningGestureForSecondPlayer = calculateWinningGestureForSecondPlayer(gestureChosenByFirstPlayer);
        return decideWhoWins(winningGestureForSecondPlayer, gestureChosenBySecondPlayer);
    }

    private Gesture calculateWinningGestureForSecondPlayer(Gesture gestureChosenByFirstPlayer) {
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
