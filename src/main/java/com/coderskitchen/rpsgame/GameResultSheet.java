package com.coderskitchen.rpsgame;

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

    public void increaseTie() {
        roundsWithTie++;
    }

    public void increaseRoundsWonByFirstPlayer() {
        roundsWonByFirstPlayer++;
    }

    public void increaseRoundsWonBySecondPlayer() {
        roundsWonBySecondPlayer++;
    }
}
