package com.factoriaf5.rps.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.factoriaf5.rps.models.Paper;
import com.factoriaf5.rps.models.Rock;
import com.factoriaf5.rps.models.Scissors;

public class MoveTest {

    @Test
    void testGetNameIsImplemented() {
        Move rock = new Rock();
        Move paper = new Paper();
        Move scissors = new Scissors();
        
        assertEquals("Rock", rock.getName());
        assertEquals("Paper", paper.getName());
        assertEquals("Scissors", scissors.getName());
    }

    @Test
    void testWinIsImplemented() {
        Move rock = new Rock();
        Move paper = new Paper();
        Move scissors = new Scissors();

        assertTrue(rock.win(scissors)); 
        assertTrue(paper.win(rock));   
        assertTrue(scissors.win(paper)); 

        assertFalse(rock.win(paper));   
        assertFalse(paper.win(scissors)); 
        assertFalse(scissors.win(rock));
    }

    @Test
    void testNoMoveWinsAgainstItself() {
        Move rock = new Rock();
        Move paper = new Paper();
        Move scissors = new Scissors();

        assertFalse(rock.win(rock));
        assertFalse(paper.win(paper));
        assertFalse(scissors.win(scissors));
    }
}
