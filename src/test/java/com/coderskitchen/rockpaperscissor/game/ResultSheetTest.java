package com.coderskitchen.rockpaperscissor.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResultSheetTest {

    @Test
    public void tieAppliedToGameResultSheetOnlyIncreasesTieCountBy1() throws Exception {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.applyRoundOutcome(RoundOutcome.TIE);
        assertThat(resultSheet.getRoundsWithTie(), is(1));
        assertThat(resultSheet.getRoundsWonByFirstPlayer(), is(0));
        assertThat(resultSheet.getRoundsWonBySecondPlayer(), is(0));
    }

    @Test
    public void firstPlayerWinsAppliedToGameResultSheetOnlyIncreasesFirstPlayerWinCountBy1() throws Exception {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.applyRoundOutcome(RoundOutcome.FIRST_PLAYER_WINS);
        assertThat(resultSheet.getRoundsWithTie(), is(0));
        assertThat(resultSheet.getRoundsWonByFirstPlayer(), is(1));
        assertThat(resultSheet.getRoundsWonBySecondPlayer(), is(0));
    }

    @Test
    public void secondPlayerWinsAppliedToGameResultSheetOnlyIncreasesSecondPlayerWinCountBy1() throws Exception {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.applyRoundOutcome(RoundOutcome.SECOND_PLAYER_WINS);
        assertThat(resultSheet.getRoundsWithTie(), is(0));
        assertThat(resultSheet.getRoundsWonByFirstPlayer(), is(0));
        assertThat(resultSheet.getRoundsWonBySecondPlayer(), is(1));
    }
}