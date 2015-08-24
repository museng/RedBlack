package com.jtsoftware.GameObjects;

/**
 * Created by Jonty on 23/08/2015.
 */
public class Card {
    public enum CardValue
    {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private int cardNumber;

        private CardValue (int value)
        {
            this.cardNumber = value;
        }

        public int getNumber() {
            return this.cardNumber;
        }
    }
    public enum Suit
    {
        CLUBS,
        SPADES,
        HEARTS,
        DIAMONDS;
    };

    public enum Colour {RED, BLACK};

    Suit suit;
    CardValue value;
    Colour colour;


    public Card(Suit suit, CardValue value){
        this.suit = suit;
        this.value = value;
        if (this.suit == Suit.CLUBS || this.suit == Suit.SPADES) {
            this.colour = Colour.BLACK;
        } else {
            this.colour = Colour.RED;
        }
    }

    public Suit getSuit() {
        return this.suit;
    }
    public CardValue getValue() {
        return this.value;
    }
    public Colour getColour() {
        return this.colour;
    }
}
