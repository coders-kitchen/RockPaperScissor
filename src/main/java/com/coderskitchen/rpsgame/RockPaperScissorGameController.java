package com.coderskitchen.rpsgame;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameController {

    public void play(RockPaperScissorGameSettings rockPaperScissorGameSettings, RuleOutcomeCallbackImpl gameRoundResultCallback) {
        RockPaperScissorRule rockPaperScissorRule = rockPaperScissorGameSettings.getRockPaperScissorRule();
        Integer numberOfRoundsLeft = rockPaperScissorGameSettings.getNumberOfRoundsToPlay();
        Player firstPlayer = rockPaperScissorGameSettings.getFirstPlayer();
        Player secondPlayer = rockPaperScissorGameSettings.getSecondPlayer();

        while (numberOfRoundsLeft > 0) {
            rockPaperScissorRule.apply(firstPlayer.chooseGesture(), secondPlayer.chooseGesture(), gameRoundResultCallback);
            numberOfRoundsLeft--;
        }
    }

    public void displayResults(RockPaperScissorGameSettings rockPaperScissorGameSettings, GameResultSheet gameResultSheet) {
        System.out.println(rockPaperScissorGameSettings.getFirstPlayer().getPlayerName() + " wins " + gameResultSheet.getRoundsWonByFirstPlayer() + " of " + rockPaperScissorGameSettings.getNumberOfRoundsToPlay() + " rounds");
        System.out.println(rockPaperScissorGameSettings.getSecondPlayer().getPlayerName() + " wins " + gameResultSheet.getRoundsWonBySecondPlayer() + " of " + rockPaperScissorGameSettings.getNumberOfRoundsToPlay() + " rounds");
        System.out.println(gameResultSheet.getRoundsWithTie() + " of " + rockPaperScissorGameSettings.getNumberOfRoundsToPlay() + " were tie games");
    }
}
