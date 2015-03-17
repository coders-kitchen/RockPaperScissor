package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.model.GameResultSheet;
import com.coderskitchen.rockpaperscissor.game.model.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.player.Player;
import com.coderskitchen.rockpaperscissor.game.player.RandomGestureChoosingStrategy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorGameServiceTest {
    @Test
    public void afterTenRoundsTheTotalOfTieAndBothPlayerWinsIsTen() throws Exception {
        RandomGestureChoosingStrategy gestureChoosingStrategy = new RandomGestureChoosingStrategy();
        RockPaperScissorGameSettings rockPaperScissorGameSettings = new RockPaperScissorGameSettings(10, new Player("1", gestureChoosingStrategy), new Player("2", gestureChoosingStrategy));
        GameResultSheet play = new RockPaperScissorGameService(new RockPaperScissorGameRule()).playGame(rockPaperScissorGameSettings);
        assertThat(play.getRoundsWonByFirstPlayer() + play.getRoundsWonBySecondPlayer() + play.getRoundsWithTie(), is(10));
    }
}