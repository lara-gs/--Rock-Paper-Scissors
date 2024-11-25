package com.factoriaf5.rps.models;

import com.factoriaf5.rps.application.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LizardTest {

    @Test
    public void testGetName() {
        Lizard lizard = new Lizard();
        assertEquals("Lizard", lizard.getName());
    }

    @Test
    public void testWinAgainstPaper() {
        Lizard lizard = new Lizard();
        Move paper = new Paper();
        assertTrue(lizard.win(paper));
    }

    @Test
    public void testWinAgainstSpock() {
        Lizard lizard = new Lizard();
        Move spock = new Spock();
        assertTrue(lizard.win(spock));
    }

    @Test
    public void testLoseAgainstRock() {
        Lizard lizard = new Lizard();
        Move rock = new Rock();
        assertFalse(lizard.win(rock));
    }

    @Test
    public void testLoseAgainstScissors() {
        Lizard lizard = new Lizard();
        Move scissors = new Scissors();
        assertFalse(lizard.win(scissors));
    }

    @Test
    public void testDrawAgainstLizard() {
        Lizard lizard1 = new Lizard();
        Lizard lizard2 = new Lizard();
        assertFalse(lizard1.win(lizard2));
    }
}
