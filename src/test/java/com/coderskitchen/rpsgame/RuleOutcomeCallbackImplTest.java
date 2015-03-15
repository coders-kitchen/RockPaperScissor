package com.coderskitchen.rpsgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RuleOutcomeCallbackImplTest {

    private GameResultSheet gameResultSheet;
    private RuleOutcomeCallbackImpl cut;
    @Before
    public void setUp() throws Exception {
        gameResultSheet = new GameResultSheet();
        cut = new RuleOutcomeCallbackImpl(gameResultSheet);

    }

    @Test
    public void tieIncreasedTieCounter() throws Exception {
        cut.tie();
        cut.tie();
        cut.tie();
        assertThat(gameResultSheet.getRoundsWithTie(), is(3));
        assertThat(gameResultSheet.getRoundsWonByFirstPlayer(), is(0));
        assertThat(gameResultSheet.getRoundsWonBySecondPlayer(), is(0));
    }

    @Test
    public void firstPlayerWinsIncreasesCounterForFirstPlayer() throws Exception {
        cut.firstPlayerWins();
        cut.firstPlayerWins();
        cut.firstPlayerWins();
        assertThat(gameResultSheet.getRoundsWithTie(), is(0));
        assertThat(gameResultSheet.getRoundsWonByFirstPlayer(), is(3));
        assertThat(gameResultSheet.getRoundsWonBySecondPlayer(), is(0));
    }

    @Test
    public void secondPlayerWinsIncreasesCounterForSecondPlayer() throws Exception {
        cut.secondPlayerWins();
        cut.secondPlayerWins();
        cut.secondPlayerWins();
        assertThat(gameResultSheet.getRoundsWithTie(), is(0));
        assertThat(gameResultSheet.getRoundsWonByFirstPlayer(), is(0));
        assertThat(gameResultSheet.getRoundsWonBySecondPlayer(), is(3));
    }
}