package com.factoriaf5.rps.application;

public abstract class Move {
    public abstract String getName();
    public abstract boolean win(Move other);
    
}
