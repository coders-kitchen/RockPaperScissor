package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.player.Player;
import com.coderskitchen.rockpaperscissor.player.RandomGestureChoosingStrategy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameEngineTest {
    @Test
    public void afterTenRoundsTheTotalOfTieAndBothPlayerWinsIsTen() throws Exception {
        RandomGestureChoosingStrategy gestureChoosingStrategy = new RandomGestureChoosingStrategy();
        GameSettings gameSettings = new GameSettings(10, new Player("1", gestureChoosingStrategy), new Player("2", gestureChoosingStrategy));
        GameResultSheet play = new GameEngine(new GameRule()).playGame(gameSettings);
        assertThat(play.getRoundsWonByFirstPlayer() + play.getRoundsWonBySecondPlayer() + play.getRoundsWithTie(), is(10));
    }
}