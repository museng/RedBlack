package com.jtsoftware.GameObjects;

import java.util.ArrayList;

/**
 * Created by Jonty on 24/08/2015.
 */
public class Deck {
    enum Suite {CLUB, HEART, SPADE, DIAMOND}

    ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();

        resetPack();


    }


    public void Shuffle(){
        //Do something maybe.

    }
    public void resetPack(){
        cards.clear();

        for(Suite suite : Suite.values()){

            for(int i = 1; i < 15; i++){
                cards.add(new Card(suite.name(), i));


            }

        }
    }
}
