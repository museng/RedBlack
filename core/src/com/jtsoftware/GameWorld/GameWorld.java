package com.jtsoftware.GameWorld;

import com.jtsoftware.GameObjects.Card;
import com.jtsoftware.GameObjects.Deck;
import com.jtsoftware.GameRenderer.GameRenderer;
import com.jtsoftware.Helpers.ActionResolver;

/**
 * Created by Jonty on 24/08/2015.
 */
public class GameWorld {
    private enum gamePhase {redOrBlack, upOrDown, inOrOut}
    private ActionResolver resolver;
    private GameRenderer renderer;
    private Deck deck;

    public GameWorld(ActionResolver resolver){
        this.resolver = resolver;

        deck = new Deck();


    }
    public void update(float delta){
        getNextCard();
        updateMenu();
    }

    public void getNextCard() {
        if (!deck.isEmpty()) {
            Card newCard = deck.getCard();
            System.out.printf("card is %s (%d) of %s, a %s card.\n", newCard.getValue(), newCard.getValue().getNumber(), newCard.getSuit(), newCard.getColour());
        }
    }

    public void updateMenu(){

    }
    public void setRenderer(GameRenderer renderer) {
        this.renderer = renderer;
    }
}
