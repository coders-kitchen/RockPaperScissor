package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.RoundOutcome;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameResultSheetTest {

    @Test
    public void tieAppliedToGameResultSheetOnlyIncreasesTieCountBy1() throws Exception {
        GameResultSheet gameResultSheet = new GameResultSheet();
        gameResultSheet.applyRoundOutcome(RoundOutcome.TIE);
        assertThat(gameResultSheet.getRoundsWithTie(), is(1));
        assertThat(gameResultSheet.getRoundsWonByFirstPlayer(), is(0));
        assertThat(gameResultSheet.getRoundsWonBySecondPlayer(), is(0));
    }

    @Test
    public void firstPlayerWinsAppliedToGameResultSheetOnlyIncreasesFirstPlayerWinCountBy1() throws Exception {
        GameResultSheet gameResultSheet = new GameResultSheet();
        gameResultSheet.applyRoundOutcome(RoundOutcome.FIRST_PLAYER_WINS);
        assertThat(gameResultSheet.getRoundsWithTie(), is(0));
        assertThat(gameResultSheet.getRoundsWonByFirstPlayer(), is(1));
        assertThat(gameResultSheet.getRoundsWonBySecondPlayer(), is(0));
    }

    @Test
    public void secondPlayerWinsAppliedToGameResultSheetOnlyIncreasesSecondPlayerWinCountBy1() throws Exception {
        GameResultSheet gameResultSheet = new GameResultSheet();
        gameResultSheet.applyRoundOutcome(RoundOutcome.SECOND_PLAYER_WINS);
        assertThat(gameResultSheet.getRoundsWithTie(), is(0));
        assertThat(gameResultSheet.getRoundsWonByFirstPlayer(), is(0));
        assertThat(gameResultSheet.getRoundsWonBySecondPlayer(), is(1));
    }
}