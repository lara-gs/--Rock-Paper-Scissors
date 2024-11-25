package com.factoriaf5.rps.models;

import com.factoriaf5.rps.application.Move;

public class Scissors extends Move{
    @Override
    public String getName() {
        return "Scissors";
    }

    @Override
    public boolean win(Move other) {
        return other instanceof Paper || other instanceof Lizard;
    }
    
}
