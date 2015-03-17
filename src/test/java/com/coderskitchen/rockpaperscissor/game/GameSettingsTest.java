package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.GameSettings;
import com.coderskitchen.rockpaperscissor.player.Gesture;
import com.coderskitchen.rockpaperscissor.player.Player;
import org.junit.Test;

public class GameSettingsTest {

    private Player testPlayer = new Player("1", () -> Gesture.ROCK);

    @Test(expected = AssertionError.class)
    public void zeroRoundsToPlayRaisesAnException() throws Exception {
        new GameSettings(0, null, null);
    }


    @Test(expected = AssertionError.class)
    public void missingFirstPlayerRaisesAnException() {
        new GameSettings(1, null, null);
    }

    @Test(expected = AssertionError.class)
    public void missingSecondPlayerRaisesAnException() throws Exception {
        new GameSettings(1, testPlayer, null);
    }
}