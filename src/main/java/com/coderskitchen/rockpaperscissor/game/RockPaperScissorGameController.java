package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.domain.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.domain.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.domain.Player;
import com.coderskitchen.rockpaperscissor.game.rule.RockPaperScissorGameRule;
import com.coderskitchen.rockpaperscissor.game.domain.RoundOutcome;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameController {

    public GameResultSheet playGame(RockPaperScissorGameSettings rockPaperScissorGameSettings) {
        Integer numberOfRoundsLeft = rockPaperScissorGameSettings.getNumberOfRoundsToPlay();

        RockPaperScissorGameRule rockPaperScissorGameRule = rockPaperScissorGameSettings.getRockPaperScissorGameRule();
        Player firstPlayer = rockPaperScissorGameSettings.getFirstPlayer();
        Player secondPlayer = rockPaperScissorGameSettings.getSecondPlayer();

        GameResultSheet gameResultSheet = new GameResultSheet();

        while (numberOfRoundsLeft > 0) {
            gameResultSheet = playRound(rockPaperScissorGameRule, firstPlayer, secondPlayer, gameResultSheet);
            numberOfRoundsLeft--;
        }
        return gameResultSheet;
    }

    private GameResultSheet playRound(RockPaperScissorGameRule rockPaperScissorGameRule, Player firstPlayer, Player secondPlayer, GameResultSheet gameResultSheet) {
        String gestureChosenByFirstPlayer = firstPlayer.chooseGesture();
        String gestureChosenBySecondPlayer = secondPlayer.chooseGesture();

        RoundOutcome roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer);
        return applyRoundOutcomeToResultSheet(roundOutcome, gameResultSheet);
    }

    private GameResultSheet applyRoundOutcomeToResultSheet(RoundOutcome roundOutcome, GameResultSheet gameResultSheet) {
        GameResultSheet updatedGameResultSheet = null;
        switch (roundOutcome) {
            case TIE:
                updatedGameResultSheet = gameResultSheet.increaseTie();
                break;
            case FIRST_PLAYER_WINS:
                updatedGameResultSheet = gameResultSheet.increaseRoundsWonByFirstPlayer();
                break;
            case SECOND_PLAYER_WINS:
                updatedGameResultSheet = gameResultSheet.increaseRoundsWonBySecondPlayer();
                break;
        }
        return updatedGameResultSheet;
    }


}
