package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.player.Player;
import com.coderskitchen.rockpaperscissor.game.player.RandomGestureChoosingStrategy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameEngineTest {
    @Test
    public void afterTenRoundsTheTotalOfTieAndBothPlayerWinsIsTen() throws Exception {
        RandomGestureChoosingStrategy gestureChoosingStrategy = new RandomGestureChoosingStrategy();
        Settings settings = new Settings(10, new Player("1", gestureChoosingStrategy), new Player("2", gestureChoosingStrategy));
        ResultSheet play = new GameEngine(new Rule()).playGame(settings);
        assertThat(play.getRoundsWonByFirstPlayer() + play.getRoundsWonBySecondPlayer() + play.getRoundsWithTie(), is(10));
    }
}