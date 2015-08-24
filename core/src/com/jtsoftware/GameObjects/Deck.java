package com.jtsoftware.GameObjects;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jonty on 24/08/2015.
 */
public class Deck {

    int remainingCards;
    ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
        remainingCards = 52;
        resetPack();
    }

    public Card getCard() {
        if (remainingCards < 1) {
            return null;
        }
        this.remainingCards -= 1;
        return cards.remove(0);
    }

    public void Shuffle(){
        Collections.shuffle(this.cards);
    }

    public boolean isEmpty() {
        return remainingCards <= 0;
    }


    public void resetPack(){
        cards.clear();
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.CardValue value: Card.CardValue.values()){
                cards.add(new Card(suit, value));
            }

        }
        this.Shuffle();
    }
}
