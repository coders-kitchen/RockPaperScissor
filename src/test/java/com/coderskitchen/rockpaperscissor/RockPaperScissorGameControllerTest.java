package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.domain.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.RockPaperScissorGameController;
import com.coderskitchen.rockpaperscissor.game.rule.RockPaperScissorGameRule;
import com.coderskitchen.rockpaperscissor.game.domain.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.domain.Player;
import com.coderskitchen.rockpaperscissor.game.gesture.RandomGestureChoosingStrategy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorGameControllerTest {
    @Test
    public void afterTenRoundsTheTotalOfTieAndBothPlayerWinsIsTen() throws Exception {
        RandomGestureChoosingStrategy gestureChoosingStrategy = new RandomGestureChoosingStrategy();
        RockPaperScissorGameSettings rockPaperScissorGameSettings = new RockPaperScissorGameSettings(10, new Player("1", gestureChoosingStrategy), new Player("2", gestureChoosingStrategy), new RockPaperScissorGameRule());
        GameResultSheet play = new RockPaperScissorGameController().playGame(rockPaperScissorGameSettings);
        assertThat(play.getRoundsWonByFirstPlayer() + play.getRoundsWonBySecondPlayer() + play.getRoundsWithTie(), is(10));
    }
}