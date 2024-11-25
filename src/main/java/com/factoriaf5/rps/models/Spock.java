package com.factoriaf5.rps.models;

import com.factoriaf5.rps.application.Move;

public class Spock extends Move{
    @Override
    public String getName(){
        return "Spock";
    }
    
    @Override
    public boolean win(Move other){
        return other instanceof Rock || other instanceof Scissors;
    }

}
