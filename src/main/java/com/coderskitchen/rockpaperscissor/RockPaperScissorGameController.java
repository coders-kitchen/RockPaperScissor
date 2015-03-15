package com.coderskitchen.rockpaperscissor;

/**
 * Created by Peter on 15.03.2015.
 */
public class RockPaperScissorGameController {

    public GameResultSheet play(RockPaperScissorGameSettings rockPaperScissorGameSettings) {
        Integer numberOfRoundsLeft = rockPaperScissorGameSettings.getNumberOfRoundsToPlay();

        RockPaperScissorGameRule rockPaperScissorGameRule = rockPaperScissorGameSettings.getRockPaperScissorGameRule();
        Player firstPlayer = rockPaperScissorGameSettings.getFirstPlayer();
        Player secondPlayer = rockPaperScissorGameSettings.getSecondPlayer();

        GameResultSheet gameResultSheet = new GameResultSheet();

        while (numberOfRoundsLeft > 0) {
            String gestureChosenByFirstPlayer = firstPlayer.chooseGesture();
            String gestureChosenBySecondPlayer = secondPlayer.chooseGesture();

            RoundOutcome roundOutcome = rockPaperScissorGameRule.calculateRoundOutcome(gestureChosenByFirstPlayer, gestureChosenBySecondPlayer);
            gameResultSheet = applyRoundOutcomeToResultSheet(roundOutcome, gameResultSheet);
            numberOfRoundsLeft--;
        }
        return gameResultSheet;
    }

    private GameResultSheet applyRoundOutcomeToResultSheet(RoundOutcome roundOutcome, GameResultSheet gameResultSheet) {
        GameResultSheet updatedGameResultSheet = null;
        switch (roundOutcome) {
            case TIE:
                updatedGameResultSheet = gameResultSheet.increaseTie();
                break;
            case FIRST_PLAYER_WINS:
                updatedGameResultSheet = gameResultSheet.increaseRoundsWonByFirstPlayer();
                break;
            case SECOND_PLAYER_WINS:
                updatedGameResultSheet = gameResultSheet.increaseRoundsWonBySecondPlayer();
                break;
        }
        return updatedGameResultSheet;
    }

    public void displayResults(RockPaperScissorGameSettings rockPaperScissorGameSettings, GameResultSheet gameResultSheet) {
        System.out.println(rockPaperScissorGameSettings.getFirstPlayer().getPlayerName() + " wins " + gameResultSheet.getRoundsWonByFirstPlayer() + " of " + rockPaperScissorGameSettings.getNumberOfRoundsToPlay() + " rounds");
        System.out.println(rockPaperScissorGameSettings.getSecondPlayer().getPlayerName() + " wins " + gameResultSheet.getRoundsWonBySecondPlayer() + " of " + rockPaperScissorGameSettings.getNumberOfRoundsToPlay() + " rounds");
        System.out.println(gameResultSheet.getRoundsWithTie() + " of " + rockPaperScissorGameSettings.getNumberOfRoundsToPlay() + " were tie games");
    }
}
