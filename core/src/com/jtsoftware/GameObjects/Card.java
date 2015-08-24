package com.jtsoftware.GameObjects;

/**
 * Created by Jonty on 23/08/2015.
 */
public class Card {

    String suite;
    int number;

    public Card(String suite, int number){
        this.suite = suite;
        this.number = number;

    }

    public String Suite(){
        return this.suite;
    }
    public int number(){

        return this.number;
    }
}
