package com.coderskitchen.rockpaperscissor.game.model;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameResultSheet {
    private Integer roundsWonByFirstPlayer = 0;
    private Integer roundsWonBySecondPlayer = 0;
    private Integer roundsWithTie = 0;

    public Integer getRoundsWonByFirstPlayer() {
        return roundsWonByFirstPlayer;
    }

    public Integer getRoundsWonBySecondPlayer() {
        return roundsWonBySecondPlayer;
    }

    public Integer getRoundsWithTie() {
        return roundsWithTie;
    }

    public void applyRoundOutcome(RoundOutcome roundOutcome) {
        switch (roundOutcome) {
            case TIE:
                this.increaseTie();
                break;
            case FIRST_PLAYER_WINS:
                this.increaseRoundsWonByFirstPlayer();
                break;
            case SECOND_PLAYER_WINS:
                this.increaseRoundsWonBySecondPlayer();
                break;
        }
    }

    private void increaseTie() {
        roundsWithTie++;
    }

    private void increaseRoundsWonByFirstPlayer() {
        roundsWonByFirstPlayer++;
    }

    private void increaseRoundsWonBySecondPlayer() {
        roundsWonBySecondPlayer++;
    }
}
