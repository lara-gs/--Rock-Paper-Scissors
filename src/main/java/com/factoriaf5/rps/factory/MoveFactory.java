package com.factoriaf5.rps.factory;

import com.factoriaf5.rps.application.Move;
import com.factoriaf5.rps.models.*;

public class MoveFactory {
    public static Move createMove(int choice) {
        switch (choice) {
            case 1:
                return new Rock();
            case 2:
                return new Paper();
            case 3:
                return new Scissors();
            case 4:
                return new Lizard();
            case 5:
                return new Spock();
            default:
                return null; 
        }
    }
}
