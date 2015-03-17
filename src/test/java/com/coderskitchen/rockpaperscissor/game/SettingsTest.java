package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.player.Gesture;
import com.coderskitchen.rockpaperscissor.player.Player;
import org.junit.Test;

public class SettingsTest {

    private Player testPlayer = new Player("1", () -> Gesture.ROCK);

    @Test(expected = IllegalArgumentException.class)
    public void zeroRoundsToPlayRaisesAnException() throws Exception {
        new Settings(0, null, null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void missingFirstPlayerRaisesAnException() {
        new Settings(1, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void missingSecondPlayerRaisesAnException() throws Exception {
        new Settings(1, testPlayer, null);
    }
}