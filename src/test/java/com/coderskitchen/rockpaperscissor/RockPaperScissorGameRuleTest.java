package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.rule.RockPaperScissorGameRule;
import com.coderskitchen.rockpaperscissor.game.domain.RoundOutcome;
import org.junit.Test;

import static com.coderskitchen.rockpaperscissor.game.gesture.RPSGestures.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorGameRuleTest {

    private final RockPaperScissorGameRule rockPaperScissorGameRule = new RockPaperScissorGameRule();

    @Test(expected = AssertionError.class)
    public void unknownGestureOfFirstPlayerRaisesException() throws Exception {
        rockPaperScissorGameRule.calculateRoundOutcome("NOTHING", PAPER);
    }

    @Test(expected = AssertionError.class)
    public void unknownGestureOfSecondPlayerRaisesException() throws Exception {
        rockPaperScissorGameRule.calculateRoundOutcome(PAPER, "NOTHING");
    }

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