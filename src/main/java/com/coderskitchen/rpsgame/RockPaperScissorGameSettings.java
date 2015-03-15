package com.coderskitchen.rpsgame;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameSettings {
    private final Integer numberOfRoundsToPlay;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final RockPaperScissorRule rockPaperScissorRule;

    public RockPaperScissorGameSettings(Integer numberOfRoundsToPlay, Player firstPlayer, Player secondPlayer, RockPaperScissorRule rockPaperScissorRule) {
        assert numberOfRoundsToPlay > 0 : "Number of rounds to play must be greater than 0";
        assert firstPlayer != null : "First player must be not null";
        assert secondPlayer != null : "Second player must be not null";
        assert rockPaperScissorRule != null : "RockPaperScissorRule must not be null";

        this.numberOfRoundsToPlay = numberOfRoundsToPlay;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.rockPaperScissorRule = rockPaperScissorRule;
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

    public RockPaperScissorRule getRockPaperScissorRule() {
        return rockPaperScissorRule;
    }
}
