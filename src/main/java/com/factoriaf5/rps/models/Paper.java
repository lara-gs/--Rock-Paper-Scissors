package com.factoriaf5.rps.models;

import com.factoriaf5.rps.application.Move;

public class Paper extends Move {

    @Override
    public String getName() {
        return "Paper";
    }

    @Override
    public boolean win(Move other) {
        return other instanceof Rock;
    }
    
}
