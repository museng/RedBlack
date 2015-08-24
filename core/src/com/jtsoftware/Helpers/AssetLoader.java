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
    public static TextureRegion logo, testAce,anotherTest;
    public static Texture logoTexture,flatCards;



    public static void load() {
        logoTexture = new Texture(Gdx.files.internal("data/JT_logo.png"));
        logoTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        testCard = new Texture(Gdx.files.internal("cards/A.png"));
        testCard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        flatCards = new Texture(Gdx.files.internal("cards/set.png"));

        anotherTest = new TextureRegion(flatCards,64,855,60,90);

        logo = new TextureRegion(logoTexture,0 ,0, 415,295);

        testAce = new TextureRegion(testCard);



    }
    public static void dispose() {


        ;

    }
}
