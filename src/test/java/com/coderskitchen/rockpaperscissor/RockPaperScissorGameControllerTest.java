package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.model.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.RockPaperScissorGameController;
import com.coderskitchen.rockpaperscissor.game.model.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.player.Player;
import com.coderskitchen.rockpaperscissor.game.player.RandomGestureChoosingStrategy;
import com.coderskitchen.rockpaperscissor.game.RockPaperScissorGameRule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorGameControllerTest {
    @Test
    public void afterTenRoundsTheTotalOfTieAndBothPlayerWinsIsTen() throws Exception {
        RandomGestureChoosingStrategy gestureChoosingStrategy = new RandomGestureChoosingStrategy();
        RockPaperScissorGameSettings rockPaperScissorGameSettings = new RockPaperScissorGameSettings(10, new Player("1", gestureChoosingStrategy), new Player("2", gestureChoosingStrategy));
        GameResultSheet play = new RockPaperScissorGameController(new RockPaperScissorGameRule()).playGame(rockPaperScissorGameSettings);
        assertThat(play.getRoundsWonByFirstPlayer() + play.getRoundsWonBySecondPlayer() + play.getRoundsWithTie(), is(10));
    }
}