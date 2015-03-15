package com.coderskitchen.rockpaperscissor;

/**
 * Created by Peter on 15.03.2015.
 */
public interface RuleOutcomeCallback {
    void tie();

    void firstPlayerWins();

    void secondPlayerWins();
}
