package com.factoriaf5.rps.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RockTest {

    @Test
    void testGetName() {
        Rock rock = new Rock();
        String name = rock.getName();
        assertEquals("Rock", name);
    }

    @Test
    void testWinAgainstScissors() {
        Rock rock = new Rock();
        Scissors scissors = new Scissors();
        boolean result = rock.win(scissors);
        assertTrue(result);
    }

    @Test
    void testLoseAgainstPaper() {
        Rock rock = new Rock();
        Paper paper = new Paper();
        boolean result = rock.win(paper);
        assertFalse(result);
    }

    @Test
    void testTieAgainstRock() {
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        boolean result = rock1.win(rock2);
        assertFalse(result);
    }
}
