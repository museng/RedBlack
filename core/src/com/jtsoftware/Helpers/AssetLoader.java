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
    public static TextureRegion logo, faceDownCard, title, red, black,correctPopup, incorrectPopup,bottle,tick,higher,lower,inside,outside,arrow;
    public static Texture logoTexture,flatCards;



    public static void load() {
        cards = new TextureRegion[60];
        logoTexture = new Texture(Gdx.files.internal("data/JT_logo.png"));

        logoTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        flatCards = new Texture(Gdx.files.internal("cards/collectionOfCards.png"));
        flatCards.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        int gap = 255;
        int cardHeight = 380;
        int pos =0;
        for(int row=0; row < 4; row++){
            for(int i=0; i < (13); i++){
                cards[pos] = new TextureRegion(flatCards,i*gap,cardHeight*row,255,380);
                cards[pos].flip(false,true);
                pos++;

            }
        }


        faceDownCard = new TextureRegion(flatCards,3315,0,255,380);

        logo = new TextureRegion(logoTexture,0 ,0, 415,295);
        red = new TextureRegion(flatCards, 0, 1952, 254, 96);
        red.flip(false, true);
        black = new TextureRegion(flatCards, 264, 1952,392, 96);
        black.flip(false, true);

        higher = new TextureRegion(flatCards,654,1916,474,131);
        higher.flip(false, true);
        lower = new TextureRegion(flatCards,1128,1943,441,105);
        lower.flip(false, true);

        inside = new TextureRegion(flatCards,654,1807,429,105);
        inside.flip(false, true);
        outside = new TextureRegion(flatCards,1090,1813,549,108);
        outside.flip(false, true);

        //testAce = new TextureRegion(testCard);

        /**      WORDS **/

        title = new TextureRegion(flatCards,0,1893,415,59);
        title.flip(false, true);




        /**   POPUP ASSETS **/

        correctPopup = new TextureRegion(flatCards,3736,1433,360,615);
        correctPopup.flip(false, true);

        incorrectPopup = new TextureRegion(flatCards,3374,1432,360,615);
        incorrectPopup.flip(false, true);
        bottle = new TextureRegion(flatCards,257,1609,88,282);
        bottle.flip(false, true);

        tick = new TextureRegion(flatCards, 0,1659,261,228);
        tick.flip(false, true);


    }
    public static void dispose() {




    }
}
