package com.factoriaf5.rps.factory;


import com.factoriaf5.rps.application.Move;
import com.factoriaf5.rps.models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveFactoryTest {

    @Test
    void testCreateMoveRock() {
        Move move = MoveFactory.createMove(1);
        assertTrue(move instanceof Rock);
    }

    @Test
    void testCreateMoveInvalid() {
        Move move = MoveFactory.createMove(6);
        assertNull(move);
    }

    @Test
void testCreateMovePaper() {
    Move move = MoveFactory.createMove(2);
    assertTrue(move instanceof Paper);
}

@Test
void testCreateMoveScissors() {
    Move move = MoveFactory.createMove(3);
    assertTrue(move instanceof Scissors);
}

@Test
void testCreateMoveLizard() {
    Move move = MoveFactory.createMove(4);
    assertTrue(move instanceof Lizard);
}

@Test
void testCreateMoveSpock() {
    Move move = MoveFactory.createMove(5);
    assertTrue(move instanceof Spock);
}

}
