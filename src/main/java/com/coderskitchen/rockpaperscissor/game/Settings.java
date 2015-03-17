package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.player.Player;

/**
 * Created by Peter on 15.03.2015.
 */
public class Settings {
    public static final String PLAYER_MUST_NOT_BE_NULL_MESSAGE = "%s player must be not null";
    public static final String ROUNDS_MUST_BE_GREATER_THAN_ZERO_MESSAGE = "Number of rounds to runGameAndDisplayResults must be greater than 0";
    private final Integer numberOfRoundsToPlay;
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Settings(Integer numberOfRoundsToPlay, Player firstPlayer, Player secondPlayer) {
        verifyThatNumberOfRoundsIsGreaterThanZero(numberOfRoundsToPlay);
        verifyThatFirstPlayerIsNotNull(firstPlayer);
        verifyThatSecondPlayerIsNotNull(secondPlayer);

        this.numberOfRoundsToPlay = numberOfRoundsToPlay;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    private void verifyThatNumberOfRoundsIsGreaterThanZero(Integer numberOfRoundsToPlay) {
        if (numberOfRoundsToPlay <= 0) {
            throw new IllegalArgumentException(ROUNDS_MUST_BE_GREATER_THAN_ZERO_MESSAGE);
        }
    }

    private void verifyThatFirstPlayerIsNotNull(Player firstPlayer) {
        if (firstPlayer == null) {
            throw new IllegalArgumentException(String.format(PLAYER_MUST_NOT_BE_NULL_MESSAGE, "First"));
        }
    }

    private void verifyThatSecondPlayerIsNotNull(Player secondPlayer) {
        if (secondPlayer == null) {
            throw new IllegalArgumentException(String.format(PLAYER_MUST_NOT_BE_NULL_MESSAGE, "Second"));
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
