package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.RockPaperScissorGameRule;
import com.coderskitchen.rockpaperscissor.game.model.RoundOutcome;
import org.junit.Test;

import static com.coderskitchen.rockpaperscissor.game.model.Gesture.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorGameRuleTest {

    private final RockPaperScissorGameRule rockPaperScissorGameRule = new RockPaperScissorGameRule();

    @Test
    public void sameGestureOfBothPlayersResultsInTie() throws Exception {
        RoundOutcome roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(PAPER, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.TIE));
    }

    @Test
    public void rockIsBeatenByPaper() throws Exception {
        RoundOutcome roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(ROCK, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(PAPER, ROCK);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }

    @Test
    public void paperIsBeatenByScissor() throws Exception {
        RoundOutcome roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(PAPER, SCISSOR);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(SCISSOR, PAPER);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }

    @Test
    public void scissorIsBeatenByRock() throws Exception {
        RoundOutcome roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(SCISSOR, ROCK);
        assertThat(roundOutcome, is(RoundOutcome.SECOND_PLAYER_WINS));
        roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(ROCK, SCISSOR);
        assertThat(roundOutcome, is(RoundOutcome.FIRST_PLAYER_WINS));
    }
}