package com.coderskitchen.rockpaperscissor.game.player;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void testName() throws Exception {
        MockGestureChoosingStrategy gestureChoosingStrategy = new MockGestureChoosingStrategy();
        Player player = new Player("TEST PLAYER", gestureChoosingStrategy);
        player.chooseGesture();

        assertThat(gestureChoosingStrategy.methodCalled, is(true));

    }

    private static class MockGestureChoosingStrategy implements GestureChoosingStrategy {

        public boolean methodCalled = false;

        @Override
        public Gesture chooseGesture() {
            methodCalled = true;
            return Gesture.ROCK;
        }
    }
}