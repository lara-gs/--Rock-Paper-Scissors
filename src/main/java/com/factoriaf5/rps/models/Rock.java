package com.factoriaf5.rps.models;

import com.factoriaf5.rps.application.Move;

public class Rock extends Move {
    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public boolean win(Move other) {
        return other instanceof Scissors || other instanceof Lizard;

    }
}
