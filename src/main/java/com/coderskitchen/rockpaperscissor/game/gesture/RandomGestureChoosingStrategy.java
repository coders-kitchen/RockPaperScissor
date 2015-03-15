package com.coderskitchen.rockpaperscissor.game.gesture;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Peter on 15.03.2015.
 */
public class RandomGestureChoosingStrategy implements GestureChoosingStrategy {
    @Override
    public String chooseGesture() {
        List<String> gestures = Arrays.asList(RPSGestures.ROCK, RPSGestures.PAPER, RPSGestures.SCISSOR);
        Collections.shuffle(gestures);
        return gestures.get(0);
    }
}
