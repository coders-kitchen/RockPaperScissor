package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.model.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.model.GameSettings;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameResultDisplayController {

    public static final String PLAYER_RESULT_MESSAGE = "Player %s wins %d of %d rounds%n";
    public static final String TIE_MESSAGE = "%d of %d rounds were tie games%n";

    public void displayResults(GameSettings gameSettings, GameResultSheet gameResultSheet) {
        Integer numberOfRoundsToPlay = gameSettings.getNumberOfRoundsToPlay();
        System.out.printf(PLAYER_RESULT_MESSAGE, gameSettings.getFirstPlayer().getPlayerName(), gameResultSheet.getRoundsWonByFirstPlayer(), numberOfRoundsToPlay);
        System.out.printf(PLAYER_RESULT_MESSAGE, gameSettings.getSecondPlayer().getPlayerName(), gameResultSheet.getRoundsWonBySecondPlayer(), numberOfRoundsToPlay);
        System.out.printf(TIE_MESSAGE, gameResultSheet.getRoundsWithTie(), numberOfRoundsToPlay);
    }
}
