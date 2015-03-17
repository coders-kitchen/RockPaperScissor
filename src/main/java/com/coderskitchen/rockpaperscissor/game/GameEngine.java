package com.coderskitchen.rockpaperscissor.game;

import com.coderskitchen.rockpaperscissor.game.model.*;
import com.coderskitchen.rockpaperscissor.game.player.Gesture;
import com.coderskitchen.rockpaperscissor.game.player.Player;

/**
 * Created by Peter on 15.03.2015.
 */
public class GameEngine {

    private final GameRule gameRule;

    public GameEngine(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public GameResultSheet playGame(GameSettings gameSettings) {
        Integer numberOfRoundsLeft = gameSettings.getNumberOfRoundsToPlay();

        Player firstPlayer = gameSettings.getFirstPlayer();
        Player secondPlayer = gameSettings.getSecondPlayer();

        GameResultSheet gameResultSheet = new GameResultSheet();

        while (numberOfRoundsLeft > 0) {
            RoundOutcome roundOutcome = playRound(firstPlayer, secondPlayer);
            gameResultSheet.applyRoundOutcome(roundOutcome);
            numberOfRoundsLeft--;
        }
        return gameResultSheet;
    }

    private RoundOutcome playRound(Player firstPlayer, Player secondPlayer) {
        Gesture gestureChosenByFirstPlayer = firstPlayer.chooseGesture();
        Gesture gestureChosenBySecondPlayer = secondPlayer.chooseGesture();

        return  gameRule.calculateRoundOutcome(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer);
    }
}
