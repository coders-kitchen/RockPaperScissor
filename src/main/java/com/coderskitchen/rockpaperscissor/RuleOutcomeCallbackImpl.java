package com.coderskitchen.rockpaperscissor;

/**
 * Created by Peter on 15.03.2015.
 */
public class RuleOutcomeCallbackImpl implements RuleOutcomeCallback {

    private final GameResultSheet gameResultSheet;

    public RuleOutcomeCallbackImpl(GameResultSheet gameResultSheet) {
        this.gameResultSheet = gameResultSheet;
    }

    @Override
    public void tie() {
        gameResultSheet.increaseTie();
    }

    @Override
    public void firstPlayerWins() {
        gameResultSheet.increaseRoundsWonByFirstPlayer();
    }

    @Override
    public void secondPlayerWins() {
        gameResultSheet.increaseRoundsWonBySecondPlayer();
    }
}
