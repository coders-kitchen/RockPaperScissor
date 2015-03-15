package com.coderskitchen.rockpaperscissor;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameSettings {
    private final Integer numberOfRoundsToPlay;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final RockPaperScissorGameRule rockPaperScissorGameRule;

    public RockPaperScissorGameSettings(Integer numberOfRoundsToPlay, Player firstPlayer, Player secondPlayer, RockPaperScissorGameRule rockPaperScissorGameRule) {
        assert numberOfRoundsToPlay > 0 : "Number of rounds to play must be greater than 0";
        assert firstPlayer != null : "First player must be not null";
        assert secondPlayer != null : "Second player must be not null";
        assert rockPaperScissorGameRule != null : "RockPaperScissorRule must not be null";

        this.numberOfRoundsToPlay = numberOfRoundsToPlay;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.rockPaperScissorGameRule = rockPaperScissorGameRule;
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

    public RockPaperScissorGameRule getRockPaperScissorGameRule() {
        return rockPaperScissorGameRule;
    }
}
