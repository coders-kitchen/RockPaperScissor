package com.coderskitchen.rockpaperscissor;

import com.coderskitchen.rockpaperscissor.game.domain.RockPaperScissorGameSettings;
import com.coderskitchen.rockpaperscissor.game.domain.Player;
import org.junit.Test;

public class RockPaperScissorGameSettingsTest {

    private Player testPlayer = new Player("1", () -> "");

    @Test(expected = AssertionError.class)
    public void zeroRoundsToPlayRaisesAnException() throws Exception {
        new RockPaperScissorGameSettings(0, null, null, null);
    }


    @Test(expected = AssertionError.class)
    public void missingFirstPlayerRaisesAnException() {
        new RockPaperScissorGameSettings(1, null, null, null);
    }

    @Test(expected = AssertionError.class)
    public void missingSecondPlayerRaisesAnException() throws Exception {
        new RockPaperScissorGameSettings(1, testPlayer, null, null);
    }

    @Test(expected = AssertionError.class)
    public void missingGameRuleRaisesAnException() throws Exception {
        new RockPaperScissorGameSettings(1, testPlayer, testPlayer, null);

    }
}