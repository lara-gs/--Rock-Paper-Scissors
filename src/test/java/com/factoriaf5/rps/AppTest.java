package com.factoriaf5.rps;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.factoriaf5.rps.application.Move;
import com.factoriaf5.rps.models.Paper;
import com.factoriaf5.rps.models.Rock;
import com.factoriaf5.rps.models.Scissors;

class AppTest {

    @Test
    void testGetMoveWithZeroReturnsNull() {
        assertNull(App.getMove(0), "La elección 0 debería devolver null");
    }

    @Test
    void testGetMoveWithNegativeNumberReturnsNull() {
        assertNull(App.getMove(-5), "Los números negativos deberían devolver null");
    }

    @Test
    void testGetMoveWithLargeNumberReturnsNull() {
        assertNull(App.getMove(1000), "Un número muy grande debería devolver null");
    }

    @Test
    void testRockDoesNotBeatPaper() {
        Move rock = new Rock();
        Move paper = new Paper();
        assertFalse(rock.win(paper), "Rock no debería ganar a Paper");
    }

    @Test
    void testPaperDoesNotBeatScissors() {
        Move paper = new Paper();
        Move scissors = new Scissors();
        assertFalse(paper.win(scissors), "Paper no debería ganar a Scissors");
    }

    @Test
    void testScissorsDoesNotBeatRock() {
        Move scissors = new Scissors();
        Move rock = new Rock();
        assertFalse(scissors.win(rock), "Scissors no debería ganar a Rock");
    }

    @Test
    void testPlayWithValidChoice() {
        String input = "1\n"; 
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try (Scanner scanner = new Scanner(System.in)) {
            App.play(scanner);
        }

        String output = out.toString();
        assertTrue(output.contains("Your play is:  Rock"), "El juego debería mostrar la elección del usuario como Rock");
        assertTrue(output.contains("The computer choice is"), "El juego debería mostrar la elección de la computadora");
        assertTrue(output.contains("You win!") || output.contains("Computer win :(") || output.contains("It's a tie!"),
                "El juego debería determinar el ganador o empate");
    }

    @Test
    void testPlayWithInvalidChoice() {
        String input = "5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try (Scanner scanner = new Scanner(System.in)) {
            App.play(scanner);
        }

        String output = out.toString();
        assertTrue(output.contains("Wrong choice, pick another to play"), "El juego debería mostrar un mensaje de error para elección inválida");
    }

    @Test
    void testPlayHandlesMultipleChoices() {
        String input = "3\n2\n"; 
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try (Scanner scanner = new Scanner(System.in)) {
            App.play(scanner); 
            App.play(scanner); 
        }

        String output = out.toString();
        assertTrue(output.contains("Your play is:  Scissors"), "Debería registrar correctamente la primera elección como Scissors");
        assertTrue(output.contains("Your play is:  Paper"), "Debería registrar correctamente la segunda elección como Paper");
    }


    @Test
    void testPlayHandlesEmptyInput() {
        String input = "\n"; 
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try (Scanner scanner = new Scanner(System.in)) {
            assertThrows(Exception.class, () -> App.play(scanner), "La entrada vacía debería lanzar una excepción");
        }
    }
}
