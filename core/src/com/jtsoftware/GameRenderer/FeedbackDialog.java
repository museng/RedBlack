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

        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        stage = new Stage(new ScreenViewport());


    }

    public void createResult(Boolean correct, Card card){

        //Set Table background color..
//        Pixmap pm1 = new Pixmap(1, 1, Pixmap.Format.RGB565);
//        pm1.setColor(Color.GREEN);
//        pm1.fill();
//        //..........
//
//        Label nameLabel = new Label("This is your result!", skin);
//        resultTable = new Table();
//
//
//        resultTable.add(nameLabel);
//        resultTable.row();
//        resultTable.add(new Image(AssetLoader.cards[3]));
//        resultTable.setFillParent(true);
//        resultTable.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(pm1))));
//        resultTable.setDebug(true);
//        stage.addActor(resultTable);



        if(correct) dialogImage = AssetLoader.correctPopup;
        else dialogImage = AssetLoader.incorrectPopup;
        tick = AssetLoader.tick;
        this.card = card;

        rect =new Rectangle((gameWidth/2) - (dialogImage.getRegionWidth()/8), (gameHeight/3),
                dialogImage.getRegionWidth()/4, dialogImage.getRegionHeight()/4);




    }





    public void drawDialog(Batch batch) {



        Dialog dialog =
                new Dialog("", skin, "dialog") {
                    protected void result (Object object) {
                        System.out.println("Chosen: " + object);
                    }
                }.text("Are you enjoying this demo?").button("Yes", true).button("No", false).key(Input.Keys.ENTER, true)
                        .key(Input.Keys.ESCAPE, false);




        dialog.add(new Image(AssetLoader.cards[3]));
        dialog.isMovable();
        dialog.isModal();




        dialog.padTop(50).padBottom(50);
//        dialog.getContentTable().add(label).width(850).row();
        dialog.getButtonTable().padTop(50);

//        TextButton dbutton = new TextButton("Yes", skin, "dialog");
//        dialog.button(dbutton, true);

//        dbutton = new TextButton("No", skin, "dialog");
//        dialog.button(dbutton, false);
        dialog.key(Input.Keys.ENTER, true).key(Input.Keys.ESCAPE, false);
        dialog.invalidateHierarchy();
        dialog.invalidate();
        dialog.layout();
        //dialog.show(stage);

        //Image card = new Image(new TextureRegion(AssetLoader.cards[4]));

        Window window = new Window("a",skin);


        window.isDragging();
        window.isMovable();
       //window.setFillParent(true);
        window.setHeight(Gdx.graphics.getHeight() / 2);
        window.setWidth(window.getWidth() / 2);
        //window.add(card);

        //window.setPosition((Gdx.graphics.getWidth()/2) -250, (Gdx.graphics.getHeight()/2)-300);
        window.pack();
        //window.draw(batch, .8f);

        //stage.addActor(window);




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
