package com.coderskitchen.rockpaperscissor.game.player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Peter on 15.03.2015.
 */
public class RandomGestureChoosingStrategy implements GestureChoosingStrategy {

	public static final int FIRST_GESTURE = 0;

	@Override
    public Gesture chooseGesture() {
        List<Gesture> gestures = Arrays.asList(Gesture.values());
        Collections.shuffle(gestures);
        return gestures.get(FIRST_GESTURE);
    }
}
