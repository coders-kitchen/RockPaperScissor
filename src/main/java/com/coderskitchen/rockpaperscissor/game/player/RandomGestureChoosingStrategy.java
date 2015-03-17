package com.coderskitchen.rockpaperscissor.game.player;

import java.util.Random;

/**
 * Created by Peter on 15.03.2015.
 */
public class RandomGestureChoosingStrategy implements GestureChoosingStrategy {

    private Random random;

    public RandomGestureChoosingStrategy() {
        random = new Random();
    }

    @Override
    public Gesture chooseGesture() {
        Gesture[] gestures = Gesture.values();
        int randomGestureIndex = random.nextInt(gestures.length);
        return gestures[randomGestureIndex];
    }
}
