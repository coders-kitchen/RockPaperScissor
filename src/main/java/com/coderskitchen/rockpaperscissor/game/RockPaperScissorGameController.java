package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.domain.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.domain.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.domain.Player;
import com.coderskitchen.rockpaperscissor.game.gesture.Gesture;
import com.coderskitchen.rockpaperscissor.game.rule.RockPaperScissorGameRule;
import com.coderskitchen.rockpaperscissor.game.domain.RoundOutcome;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameController {

    private final RockPaperScissorGameRule rockPaperScissorGameRule;

    public RockPaperScissorGameController(RockPaperScissorGameRule rockPaperScissorGameRule) {
        this.rockPaperScissorGameRule = rockPaperScissorGameRule;
    }

    public GameResultSheet playGame(RockPaperScissorGameSettings rockPaperScissorGameSettings) {
        Integer numberOfRoundsLeft = rockPaperScissorGameSettings.getNumberOfRoundsToPlay();

        Player firstPlayer = rockPaperScissorGameSettings.getFirstPlayer();
        Player secondPlayer = rockPaperScissorGameSettings.getSecondPlayer();

        GameResultSheet gameResultSheet = new GameResultSheet();

        while (numberOfRoundsLeft > 0) {
            RoundOutcome roundOutcome = playRound(rockPaperScissorGameRule, firstPlayer, secondPlayer);
            gameResultSheet.applyRoundOutcome(roundOutcome);
            numberOfRoundsLeft--;
        }
        return gameResultSheet;
    }

    private RoundOutcome playRound(RockPaperScissorGameRule rockPaperScissorGameRule, Player firstPlayer, Player secondPlayer) {
        Gesture gestureChosenByFirstPlayer = firstPlayer.chooseGesture();
        Gesture gestureChosenBySecondPlayer = secondPlayer.chooseGesture();

        return  rockPaperScissorGameRule.calculateRoundOutcome(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer);

    }
}
