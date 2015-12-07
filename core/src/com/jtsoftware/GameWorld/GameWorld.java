package com.jtsoftware.GameWorld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.jtsoftware.GameObjects.Card;
import com.jtsoftware.GameObjects.Deck;
import com.jtsoftware.GameObjects.FaceDownCard;
import com.jtsoftware.GameRenderer.FeedbackDialog;
import com.jtsoftware.GameRenderer.GameRenderer;
import com.jtsoftware.Helpers.ActionResolver;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jonty on 24/08/2015.
 */
public class GameWorld {

    private FaceDownCard fdCard;

    public enum GameState {TITLE, CORRECT, INCORRECT, CARDPICKED, ROUND, GAMEOVER}

    ;

    public enum GamePhase {REDBLACK, UPDOWN, INOUT};

    public enum Choice {
        RED(0), BLACK(1), DOWN(0), UP(1), IN(0), OUT(1), NONE(-1);
        private int choiceValue;

        private Choice(int value) {
            this.choiceValue = value;
        }

        public int getValue() {
            return this.choiceValue;
        }
        public void setChoice(int choice){this.choiceValue = choice;}
    }

    private ActionResolver resolver;
    private GameRenderer renderer;
    private Deck deck;
    private Card newCard;
    public GamePhase phase;
    private boolean wasCorrect;
    private ArrayList<Card> prevCards;
    private Random RANDOM = new Random();

    private FeedbackDialog dialog;
    public float gameWidth, gameHeight;

    public GameState state;

    public Choice choice;


    public GameWorld(ActionResolver resolver) {

        this.wasCorrect = true;
        this.resolver = resolver;
        this.phase = GamePhase.REDBLACK;
        this.deck = new Deck();
        this.prevCards = new ArrayList<Card>();
        this.state = GameState.ROUND;

        this.choice = Choice.NONE;



        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        this.gameWidth = 136;
        this.gameHeight = screenHeight / (screenWidth / gameWidth);

        this.fdCard = new FaceDownCard(gameWidth, gameHeight);

        dialog = new FeedbackDialog(this.gameWidth);


    }

    public boolean isCorrect(int choice) {
        if (this.phase == GamePhase.REDBLACK) {
            if (choice == Choice.RED.getValue()) {
                return this.newCard.getColour() == Card.Colour.RED;
            } else {
                return this.newCard.getColour() == Card.Colour.BLACK;
            }

        } else if (this.phase == GamePhase.UPDOWN) {
            if (choice == Choice.UP.getValue()) {
                System.out.printf("Is %s greater than %s?\n",newCard.getValue().getNumber(), prevCards.get(0).getValue());
                return this.newCard.getValue().getNumber() > this.prevCards.get(0).getValue().getNumber();
            } else {
                return this.newCard.getValue().getNumber() < this.prevCards.get(0).getValue().getNumber();
            }

        } else {
            int maxVal = Math.max(this.prevCards.get(0).getValue().getNumber(), this.prevCards.get(1).getValue().getNumber());
            int minVal = Math.min(this.prevCards.get(0).getValue().getNumber(), this.prevCards.get(1).getValue().getNumber());
            if (choice == Choice.IN.getValue()) {
                return this.newCard.getValue().getNumber() > minVal && this.newCard.getValue().getNumber() < maxVal;
            } else {
                return this.newCard.getValue().getNumber() < minVal || this.newCard.getValue().getNumber() > maxVal;
            }

        }

    }

    public void update(float delta) {
        if (!this.deck.isEmpty()) {


            switch(state){
                case CARDPICKED:
                    handleDraw();
                    break;

                case CORRECT:
                    //System.out.println("created the Result");


                    break;

                case INCORRECT:

                    break;

            }



//            System.out.printf("New game phase: %s\n", this.phase.name());
//            getNextCard();
//            int choice = getChoice();
//            System.out.printf("Choice was number %d\n", choice);
//            this.wasCorrect = isCorrect(choice);
//            System.out.printf("Choice was %b\n", wasCorrect);


        }


        updateMenu();
    }

    public FaceDownCard faceDownCard() {
        return this.fdCard;
    }

    public void getNextCard() {
        if (!this.deck.isEmpty()) {

            this.newCard = this.deck.getCard();
            System.out.printf("New card is %s (%d) of %s, a %s card.\n", this.newCard.getValue(),
                    this.newCard.getValue().getNumber(), this.newCard.getSuit(), this.newCard.getColour());
        }
    }

    public int getChoice() {
        return choice.getValue();
    }

    public void updatePrevCards() {
        if ( !this.wasCorrect) {
            this.prevCards.clear();
        } else {
            if(this.phase != GamePhase.REDBLACK){
                this.prevCards.add(0, this.newCard);
            }

        }
    }

    public void updateGamePhase() {
        if(state == GameState.CORRECT){
            int nextPhaseOrd = (this.phase.ordinal() + 1) % 3;

            this.phase = GamePhase.values()[nextPhaseOrd];
            System.out.println("NEW PHASE: " + this.phase.name());
            this.state = GameState.ROUND;
        }
        else{
            state = GameState.ROUND;
            phase = GamePhase.REDBLACK;
        }


    }


    public boolean isPhaseRedBlack() {
        return phase == GamePhase.REDBLACK;
    }

    public void updateMenu() {

    }


    public void setRenderer(GameRenderer renderer) {
        this.renderer = renderer;
    }

    public FeedbackDialog getDialog() {
        return this.dialog;
    }

    public void handleDraw() {
        updatePrevCards();
        getNextCard();

        //Suits need to match.
        if(isCorrect(getChoice())){
            state = GameState.CORRECT;
            dialog.createResult(true,newCard);

        }
        else{
            state = GameState.INCORRECT;
            dialog.createResult(false,newCard);
        }

    }


}
