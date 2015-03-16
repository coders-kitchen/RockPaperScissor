package com.coderskitchen.rockpaperscissor.game.gesture;

import com.coderskitchen.rockpaperscissor.game.domain.Gesture;

/**
 * Created by Peter on 15.03.2015.
 */
public interface GestureChoosingStrategy {
    Gesture chooseGesture();
}
