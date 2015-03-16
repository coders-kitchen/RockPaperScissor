package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.player.Gesture;
import com.coderskitchen.rockpaperscissor.game.model.RoundOutcome;

import static com.coderskitchen.rockpaperscissor.game.player.Gesture.*;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameRule {

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
