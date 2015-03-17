package com.coderskitchen.rockpaperscissor.game.model;

import com.coderskitchen.rockpaperscissor.game.player.Player;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameSettings {
    private final Integer numberOfRoundsToPlay;
    private final Player firstPlayer;
    private final Player secondPlayer;

    public GameSettings(Integer numberOfRoundsToPlay, Player firstPlayer, Player secondPlayer) {
        assert numberOfRoundsToPlay > 0 : "Number of rounds to runGameAndDisplayResults must be greater than 0";
        assert firstPlayer != null : "First player must be not null";
        assert secondPlayer != null : "Second player must be not null";

        this.numberOfRoundsToPlay = numberOfRoundsToPlay;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Integer getNumberOfRoundsToPlay() {
        return numberOfRoundsToPlay;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

}
