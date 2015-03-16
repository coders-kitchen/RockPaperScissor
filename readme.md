# Rock Paper Scissor (RPS) - An exercise

## Introduction

This small project implements the game Rock Paper Scissor in respect to the following game rules

    1. The game is played by 2 players
    2. In each round each player chooses from one of the following gestures Rock, Paper or Scissor.
    3. The chosen gestures are compared to determine which player wins the round

           * Rock beats Scissor
           * Scissor beats Paper
           * Paper beats Rock
           * Same gestures are handled as tie.

The implementation follows these requirements

    1. The program should execute 100 rounds
    2. One player constantly chooses Paper
    3. The other player chooses randomly one of the gestures
    4. After the last round a statistic of the game is printed out.
       The statistic should contain the rounds won by each player and the number of ties

## Requirements

The RPS requires Java 1.8+

## Building

For building RPS execute

    ./gradlew jar

## Running

### The game

For running RPS execute

    ./gradlew run

### The tests

For running the tests execute

    ./gradlew test


## Open tasks

Add documentation to methods / classes
