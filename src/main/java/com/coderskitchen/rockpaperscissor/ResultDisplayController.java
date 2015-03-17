package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.ResultSheet;
import com.coderskitchen.rockpaperscissor.game.Settings;

/**
 * Created by Peter on 15.03.2015.
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
