package com.jtsoftware.GameObjects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jonty on 24/08/2015.
 */
public class Deck {
    enum Suit {CLUB, HEART, SPADE, DIAMOND}
    Random numGen;
    int remainingCards;
    ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
        remainingCards = 52;
        numGen = new Random();

        resetPack();
    }

    public Card getCard() {
        if (remainingCards < 1) {
            return null;
        }
        int cardIndex = numGen.nextInt(this.remainingCards);
        this.remainingCards -= 1;
        return cards.remove(cardIndex);
    }

    public void Shuffle(){
        //Do something maybe.

    }
    public void resetPack(){
        cards.clear();

        for(Suit suite : Suit.values()){

            for(int i = 1; i < 15; i++){
                cards.add(new Card(suite.name(), i));
            }

        }
    }
}
