package com.coderskitchen.rockpaperscissor.game;

import org.junit.Test;

import static com.coderskitchen.rockpaperscissor.game.player.Gesture.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RuleTest {

    private final Rule rule = new Rule();

    @Test
    public void sameGestureOfBothPlayersResultsInTie() throws Exception {
        RoundOutcome roundOutcome = rule.calculateRoundOutcome(PAPER, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.TIE));
    }

    @Test
    public void rockIsBeatenByPaper() throws Exception {
        RoundOutcome roundOutcome = rule.calculateRoundOutcome(ROCK, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = rule.calculateRoundOutcome(PAPER, ROCK);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }

    @Test
    public void paperIsBeatenByScissor() throws Exception {
        RoundOutcome roundOutcome = rule.calculateRoundOutcome(PAPER, SCISSOR);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = rule.calculateRoundOutcome(SCISSOR, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }

    @Test
    public void scissorIsBeatenByRock() throws Exception {
        RoundOutcome roundOutcome = rule.calculateRoundOutcome(SCISSOR, ROCK);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = rule.calculateRoundOutcome(ROCK, SCISSOR);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }
}