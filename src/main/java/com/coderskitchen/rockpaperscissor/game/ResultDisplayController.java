package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.domain.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.domain.RockPaperScissorGameSettings;

/**
 * Created by Peter on 15.03.2015.
 */
public class ResultDisplayController {

    public static final String PLAYER_RESULT_MESSAGE = "Player %s wins %d of %d rounds%n";
    public static final String TIE_MESSAGE = "%d of %d rounds were tie games%n";

    public void displayResults(RockPaperScissorGameSettings rockPaperScissorGameSettings, GameResultSheet gameResultSheet) {
        Integer numberOfRoundsToPlay = rockPaperScissorGameSettings.getNumberOfRoundsToPlay();
        System.out.printf(PLAYER_RESULT_MESSAGE, rockPaperScissorGameSettings.getFirstPlayer().getPlayerName(), gameResultSheet.getRoundsWonByFirstPlayer(), numberOfRoundsToPlay);
        System.out.printf(PLAYER_RESULT_MESSAGE, rockPaperScissorGameSettings.getSecondPlayer().getPlayerName(), gameResultSheet.getRoundsWonBySecondPlayer(), numberOfRoundsToPlay);
        System.out.printf(TIE_MESSAGE, gameResultSheet.getRoundsWithTie(), numberOfRoundsToPlay);
    }
}
