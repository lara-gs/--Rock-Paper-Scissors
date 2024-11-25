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
        assertTrue(rock.win(scissors));
    }

    @Test
    void testWinAgainstLizard() {
        Rock rock = new Rock();
        Lizard lizard = new Lizard();
        assertTrue(rock.win(lizard));
    }

    @Test
    void testLoseAgainstPaper() {
        Rock rock = new Rock();
        Paper paper = new Paper();
        assertFalse(rock.win(paper));
    }

    @Test
    void testLoseAgainstSpock() {
        Rock rock = new Rock();
        Spock spock = new Spock();
        assertFalse(rock.win(spock));
    }

    @Test
    void testTieAgainstRock() {
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        assertFalse(rock1.win(rock2));
    }

    @Test
    void testWinAgainstNull() {
        Rock rock = new Rock();
        assertFalse(rock.win(null));
    }
}
