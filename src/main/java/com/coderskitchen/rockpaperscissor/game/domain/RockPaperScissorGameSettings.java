package com.coderskitchen.rockpaperscissor.game.domain;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameSettings {
    private final Integer numberOfRoundsToPlay;
    private final Player firstPlayer;
    private final Player secondPlayer;

    public RockPaperScissorGameSettings(Integer numberOfRoundsToPlay, Player firstPlayer, Player secondPlayer) {
        assert numberOfRoundsToPlay > 0 : "Number of rounds to runGameAndDisplayResults must be greater than 0";
        assert firstPlayer != null : "First gesture must be not null";
        assert secondPlayer != null : "Second gesture must be not null";

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
