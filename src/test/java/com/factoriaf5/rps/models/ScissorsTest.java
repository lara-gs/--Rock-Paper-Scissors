package com.factoriaf5.rps.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScissorsTest {

    @Test
    void testGetName() {
        Scissors scissors = new Scissors();
        String name = scissors.getName();
        assertEquals("Scissors", name);
    }

    @Test
    void testWinAgainstPaper() {
        Scissors scissors = new Scissors();
        Paper paper = new Paper();
        boolean result = scissors.win(paper);
        assertTrue(result);
    }

    @Test
    void testLoseAgainstRock() {
        Scissors scissors = new Scissors();
        Rock rock = new Rock();
        boolean result = scissors.win(rock);
        assertFalse(result);
    }

    @Test
    void testTieAgainstScissors() {
        Scissors scissors1 = new Scissors();
        Scissors scissors2 = new Scissors();
        boolean result = scissors1.win(scissors2);
        assertFalse(result);
    }
}
