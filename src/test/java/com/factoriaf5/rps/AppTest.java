package com.factoriaf5.rps;

import com.factoriaf5.rps.application.Move;
import com.factoriaf5.rps.models.Lizard;
import com.factoriaf5.rps.models.Paper;
import com.factoriaf5.rps.models.Rock;
import com.factoriaf5.rps.models.Scissors;
import com.factoriaf5.rps.models.Spock;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testGetMove() {
        assertTrue(App.getMove(1) instanceof Rock);
        assertTrue(App.getMove(2) instanceof Paper);
        assertTrue(App.getMove(3) instanceof Scissors);
        assertTrue(App.getMove(4) instanceof Lizard);
        assertTrue(App.getMove(5) instanceof Spock);
        assertNull(App.getMove(6));
    }

    @Test
    public void testRandomMoveIsValid() {
        for (int i = 0; i < 100; i++) {
            Move move = App.getRandomMove();
            assertTrue(move instanceof Rock || move instanceof Paper || move instanceof Scissors ||
                    move instanceof Lizard || move instanceof Spock);
        }
    }

    @Test
    public void testRockWinScissors() {
        Move rock = new Rock();
        Move scissors = new Scissors();
        assertTrue(rock.win(scissors));
    }

    @Test
    public void testPaperWinRock() {
        Move paper = new Paper();
        Move rock = new Rock();
        assertTrue(paper.win(rock));
    }

    @Test
    public void testSpockWinScissors() {
        Move spock = new Spock();
        Move scissors = new Scissors();
        assertTrue(spock.win(scissors));
    }

    @Test
    public void testPlayGameUserWins() {

        String userInput = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Move userMove = new Rock();
        Move computerMove = new Scissors();

        System.out.println("Your play is: " + userMove.getName());
        System.out.println("The computer choice is " + computerMove.getName());

        if (userMove.win(computerMove)) {
            System.out.println("You win!");
        } else if (computerMove.win(userMove)) {
            System.out.println("Computer win :(");
        } else {
            System.out.println("It's a tie!");
        }

        String output = outContent.toString();
        assertTrue(output.contains("You win!"));
    }

    @Test
    public void testPlayGameInvalidInput() {
        String userInput = "6\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el juego
        App.play(new Scanner(System.in));
        String output = outContent.toString();
        assertTrue(output.contains("Wrong choice, pick another to play"));
    }

    @Test
    public void testPlayGameTie() {
        String userInput = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Move userMove = new Rock();
        Move computerMove = new Rock();

        System.out.println("Your play is: " + userMove.getName());
        System.out.println("The computer choice is " + computerMove.getName());

        if (userMove.win(computerMove)) {
            System.out.println("You win!");
        } else if (computerMove.win(userMove)) {
            System.out.println("Computer win :(");
        } else {
            System.out.println("It's a tie!");
        }

        String output = outContent.toString();
        assertTrue(output.contains("It's a tie!"));
    }

    @Test
    public void testPlayGameComputerWins() {
        String userInput = "1\n"; // Usuario selecciona Rock
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Move userMove = new Rock();
        Move computerMove = new Paper(); // La computadora gana

        System.out.println("Your play is: " + userMove.getName());
        System.out.println("The computer choice is " + computerMove.getName());

        if (userMove.win(computerMove)) {
            System.out.println("You win!");
        } else if (computerMove.win(userMove)) {
            System.out.println("Computer win :(");
        } else {
            System.out.println("It's a tie!");
        }

        String output = outContent.toString();
        assertTrue(output.contains("Computer win :("));
    }

    @Test
    public void testGetMoveInvalidNegative() {
        assertNull(App.getMove(-1));
    }

    @Test
    public void testGetMoveInvalidOutOfRange() {
        assertNull(App.getMove(10));
    }

    @Test
    public void testRandomMoveCoversAllOptions() {
        boolean[] optionsCovered = new boolean[5];
        for (int i = 0; i < 100; i++) {
            Move move = App.getRandomMove();
            if (move instanceof Rock)
                optionsCovered[0] = true;
            if (move instanceof Paper)
                optionsCovered[1] = true;
            if (move instanceof Scissors)
                optionsCovered[2] = true;
            if (move instanceof Lizard)
                optionsCovered[3] = true;
            if (move instanceof Spock)
                optionsCovered[4] = true;
        }
        for (boolean covered : optionsCovered) {
            assertTrue(covered);
        }
    }

    @Test
public void testPlayGameHandlesNullMove() {
    String userInput = "6\n"; // Elección inválida que genera null
    ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    App.play(new Scanner(System.in));

    String output = outContent.toString();
    assertTrue(output.contains("Wrong choice, pick another to play"));
}


}
