package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.player.Player;

/**
 * Created by Peter on 15.03.2015.
 */
public class Settings {
    private final Integer numberOfRoundsToPlay;
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Settings(Integer numberOfRoundsToPlay, Player firstPlayer, Player secondPlayer) {
        verifyThatNumberOfRoundsIsGreaterThanZero(numberOfRoundsToPlay);
        verifyThatPlayerIsNotNull(firstPlayer, "First");
        verifyThatPlayerIsNotNull(secondPlayer, "Second");

        this.numberOfRoundsToPlay = numberOfRoundsToPlay;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    private void verifyThatNumberOfRoundsIsGreaterThanZero(Integer numberOfRoundsToPlay) {
        if (numberOfRoundsToPlay <= 0) {
            throw new IllegalArgumentException("Number of rounds to runGameAndDisplayResults must be greater than 0");
        }
    }

    private void verifyThatPlayerIsNotNull(Player player, String playerPosition) {
        if (player == null) {
            throw new IllegalArgumentException(String.format("%s player must be not null", playerPosition));
        }
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
