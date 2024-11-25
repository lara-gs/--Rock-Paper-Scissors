package com.factoriaf5.rps.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaperTest {

    @Test
    void testGetName() {
        Paper paper = new Paper();
        String name = paper.getName();
        assertEquals("Paper", name);
    }

    @Test
    void testWinAgainstRock() {
        Paper paper = new Paper();
        Rock rock = new Rock();
        boolean result = paper.win(rock);
        assertTrue(result);
    }

    @Test
    void testLoseAgainstScissors() {
        Paper paper = new Paper();
        Scissors scissors = new Scissors();
        boolean result = paper.win(scissors);
        assertFalse(result);
    }

    @Test
    void testTieAgainstPaper() {
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        boolean result = paper1.win(paper2);
        assertFalse(result);
    }

    @Test
    void testWinAgainstSpock() {
        Paper paper = new Paper();
        Spock spock = new Spock();
        boolean result = paper.win(spock);
        assertTrue(result);
    }

    @Test
    void testWinAgainstNull() {
        Paper paper = new Paper();
        boolean result = paper.win(null);
        assertFalse(result);
    }

}
