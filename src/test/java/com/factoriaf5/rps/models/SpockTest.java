package com.factoriaf5.rps.models;

import com.factoriaf5.rps.application.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpockTest {

    @Test
    public void testGetName() {
        Spock spock = new Spock();
        assertEquals("Spock", spock.getName());
    }

    @Test
    public void testWinAgainstRock() {
        Spock spock = new Spock();
        Move rock = new Rock();
        assertTrue(spock.win(rock));
    }

    @Test
    public void testWinAgainstScissors() {
        Spock spock = new Spock();
        Move scissors = new Scissors();
        assertTrue(spock.win(scissors));
    }

    @Test
    public void testLoseAgainstPaper() {
        Spock spock = new Spock();
        Move paper = new Paper();
        assertFalse(spock.win(paper));
    }

    @Test
    public void testLoseAgainstLizard() {
        Spock spock = new Spock();
        Move lizard = new Lizard();
        assertFalse(spock.win(lizard));
    }

    @Test
    public void testDrawAgainstSpock() {
        Spock spock1 = new Spock();
        Spock spock2 = new Spock();
        assertFalse(spock1.win(spock2));
    }

    @Test
    public void testWinAgainstNull() {
        Spock spock = new Spock();
        assertFalse(spock.win(null));
    }

}
