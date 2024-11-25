package com.factoriaf5.rps;

import java.util.Scanner;

import com.factoriaf5.rps.application.Move;
import com.factoriaf5.rps.factory.MoveFactory;

public class App {
    public static Move getMove(int choice) {
        return MoveFactory.createMove(choice);
    }

    public static Move getRandomMove() {
        int randomChoice = (int) (Math.random() * 5) + 1;
        return getMove(randomChoice);
    }

    public static void play(Scanner scanner) {
        System.out.println("Pick your choice: 1 for 'Rock', 2 for 'Paper', 3 for 'Scissors', 4 'Lizard', 5 'Spock'");
        int playerChoice = scanner.nextInt();
        Move userMove = getMove(playerChoice);

        if (userMove == null) {
            System.out.println("Wrong choice, pick another to play");
            return;
        }

        Move computerMove = getRandomMove();
        System.out.println("Your play is: " + userMove.getName());
        System.out.println("The computer choice is " + computerMove.getName());

        if (userMove.win(computerMove)) {
            System.out.println("You win!");
        } else if (computerMove.win(userMove)) {
            System.out.println("Computer win :(");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            play(scanner);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}