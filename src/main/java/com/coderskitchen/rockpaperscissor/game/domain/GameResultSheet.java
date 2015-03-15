package com.coderskitchen.rockpaperscissor.game.domain;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameResultSheet {
    private final Integer roundsWonByFirstPlayer;
    private final Integer roundsWonBySecondPlayer;
    private final Integer roundsWithTie;

    public GameResultSheet() {
        this(0,0,0);
    }

    public GameResultSheet(Integer roundsWonByFirstPlayer, Integer roundsWonBySecondPlayer, Integer roundsWithTie) {
        this.roundsWonByFirstPlayer = roundsWonByFirstPlayer;
        this.roundsWonBySecondPlayer = roundsWonBySecondPlayer;
        this.roundsWithTie = roundsWithTie;
    }

    public Integer getRoundsWonByFirstPlayer() {
        return roundsWonByFirstPlayer;
    }

    public Integer getRoundsWonBySecondPlayer() {
        return roundsWonBySecondPlayer;
    }

    public Integer getRoundsWithTie() {
        return roundsWithTie;
    }

    public GameResultSheet applyRoundOutcome(RoundOutcome roundOutcome) {
        GameResultSheet updatedGameResultSheet = null;
        switch (roundOutcome) {
            case TIE:
                updatedGameResultSheet = this.increaseTie();
                break;
            case FIRST_PLAYER_WINS:
                updatedGameResultSheet = this.increaseRoundsWonByFirstPlayer();
                break;
            case SECOND_PLAYER_WINS:
                updatedGameResultSheet = this.increaseRoundsWonBySecondPlayer();
                break;
        }
        return updatedGameResultSheet;
    }

    private GameResultSheet increaseTie() {
        int increasedTie = roundsWithTie + 1;
        return new GameResultSheet(roundsWonByFirstPlayer, roundsWonBySecondPlayer, increasedTie);
    }

    private GameResultSheet increaseRoundsWonByFirstPlayer() {
        int increasedRoundsWonByFirstPlayer = roundsWonByFirstPlayer + 1;
        return new GameResultSheet(increasedRoundsWonByFirstPlayer, roundsWonBySecondPlayer, roundsWithTie);
    }

    private GameResultSheet increaseRoundsWonBySecondPlayer() {
        int increasedRoundsWonBySecondPlayer = roundsWonBySecondPlayer + 1;
        return new GameResultSheet(roundsWonByFirstPlayer, increasedRoundsWonBySecondPlayer, roundsWithTie);
    }
}
