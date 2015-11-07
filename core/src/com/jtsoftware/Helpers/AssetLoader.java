package com.jtsoftware.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Jonty on 23/08/2015.
 */
public class AssetLoader {

    public static Texture cardTexture, testCard;

    public static TextureRegion[] cards;
    public static TextureRegion logo, faceDownCard, title, red, black;
    public static Texture logoTexture,flatCards;



    public static void load() {
        cards = new TextureRegion[15];
        logoTexture = new Texture(Gdx.files.internal("data/JT_logo.png"));

        logoTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        flatCards = new Texture(Gdx.files.internal("cards/collectionOfCards.png"));
        flatCards.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        int gap = 255;

        for(int i=0; i < 15; i++){
            cards[i] = new TextureRegion(flatCards,i*gap,0,255,380);
            cards[i].flip(false,true);

        }
        faceDownCard = new TextureRegion(flatCards,gap*14,0,255,380);

        logo = new TextureRegion(logoTexture,0 ,0, 415,295);
        red = new TextureRegion(flatCards, 0, 1952, 254, 96);
        red.flip(false, true);
        black = new TextureRegion(flatCards, 264, 1952,392, 96);
        black.flip(false, true);
        //testAce = new TextureRegion(testCard);

        /**      WORDS **/

        title = new TextureRegion(flatCards,0,1893,415,59);
        title.flip(false, true);


    }
    public static void dispose() {




    }
}
