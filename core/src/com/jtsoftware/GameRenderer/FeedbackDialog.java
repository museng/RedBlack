package com.jtsoftware.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jtsoftware.GameObjects.Card;
import com.jtsoftware.Helpers.AssetLoader;


/**
 * Created by Jonty on 03-Dec-15.
 */
public class FeedbackDialog {
    private Stage stage;
    private SpriteBatch batch;
    private Skin skin;
    Table resultTable;
    Card card;
    TextureRegion dialogImage;
    TextureRegion tick;
    float gameHeight, gameWidth;
    Rectangle rect;
    public FeedbackDialog(float gameWidth) {
        this.gameWidth = gameWidth;
        gameHeight = Gdx.graphics.getHeight()/ (Gdx.graphics.getWidth() / gameWidth);




    }

    public void createResult(Boolean correct, Card card){


        if(correct) dialogImage = AssetLoader.correctPopup;
        else dialogImage = AssetLoader.incorrectPopup;
        tick = AssetLoader.tick;
        this.card = card;

        rect =new Rectangle((gameWidth/2) - (dialogImage.getRegionWidth()/8), (gameHeight/3),
                dialogImage.getRegionWidth()/4, dialogImage.getRegionHeight()/4);



    }





    public void drawDialog(Batch batch) {





       // stage.draw();
        TextureRegion cardAsset = this.card.getAsset();
        batch.draw(dialogImage,(gameWidth/2) - (dialogImage.getRegionWidth()/8), (gameHeight/3),
                dialogImage.getRegionWidth()/4, dialogImage.getRegionHeight()/4 );
        batch.draw(cardAsset,(gameWidth/2) - (cardAsset.getRegionWidth()/8),
                ((gameHeight/3) + dialogImage.getRegionHeight()/4*0.9f) - (cardAsset.getRegionHeight()/4),
                cardAsset.getRegionWidth()/4, cardAsset.getRegionHeight()/4 );


    }

    public Rectangle getDialogBounds(){
        return rect;
    }

}
