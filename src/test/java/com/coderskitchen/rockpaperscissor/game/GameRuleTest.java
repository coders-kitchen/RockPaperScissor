package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.model.RoundOutcome;
import org.junit.Test;

import static com.coderskitchen.rockpaperscissor.player.Gesture.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameRuleTest {

    private final GameRule gameRule = new GameRule();

    @Test
    public void sameGestureOfBothPlayersResultsInTie() throws Exception {
        RoundOutcome roundOutcome = gameRule.calculateRoundOutcome(PAPER, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.TIE));
    }

    @Test
    public void rockIsBeatenByPaper() throws Exception {
        RoundOutcome roundOutcome = gameRule.calculateRoundOutcome(ROCK, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = gameRule.calculateRoundOutcome(PAPER, ROCK);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }

    @Test
    public void paperIsBeatenByScissor() throws Exception {
        RoundOutcome roundOutcome = gameRule.calculateRoundOutcome(PAPER, SCISSOR);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = gameRule.calculateRoundOutcome(SCISSOR, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }

    @Test
    public void scissorIsBeatenByRock() throws Exception {
        RoundOutcome roundOutcome = gameRule.calculateRoundOutcome(SCISSOR, ROCK);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = gameRule.calculateRoundOutcome(ROCK, SCISSOR);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }
}