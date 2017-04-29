package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.ResultSheet;
import com.coderskitchen.rockpaperscissor.game.Settings;

/**
 * This class is responsible for displaying the results.
 * As there is no need actually for having this abstract this class is not interface based.
 * An future version could base upon an interface to have multiple display variants possible
 */
public class ResultDisplayController {

    public static final String PLAYER_RESULT_MESSAGE = "Player %s wins %d of %d rounds%n";
    public static final String TIE_MESSAGE = "%d of %d rounds were tie games%n";

    public void displayResults(Settings settings, ResultSheet resultSheet) {
        Integer numberOfRoundsToPlay = settings.getNumberOfRoundsToPlay();
        System.out.printf(PLAYER_RESULT_MESSAGE, settings.getFirstPlayer().getPlayerName(), resultSheet.getRoundsWonByFirstPlayer(), numberOfRoundsToPlay);
        System.out.printf(PLAYER_RESULT_MESSAGE, settings.getSecondPlayer().getPlayerName(), resultSheet.getRoundsWonBySecondPlayer(), numberOfRoundsToPlay);
        System.out.printf(TIE_MESSAGE, resultSheet.getRoundsWithTie(), numberOfRoundsToPlay);
    }
}
