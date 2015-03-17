package com.coderskitchen.rockpaperscissor.game.player;

/**
 * Created by Peter on 15.03.2015.
 */
public class Player {
    private final String playerName;
    private final GestureChoosingStrategy gestureChoosingStrategy;

    public Player(String playerName, GestureChoosingStrategy gestureChoosingStrategy) {
        this.playerName = playerName;
        this.gestureChoosingStrategy = gestureChoosingStrategy;
    }

    public Gesture chooseGesture() {
        return gestureChoosingStrategy.chooseGesture();
    }

    public String getPlayerName() {
        return playerName;
    }
}
