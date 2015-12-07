package com.jtsoftware.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.jtsoftware.GameWorld.GameWorld;
import com.jtsoftware.GameWorld.UITest;
import com.jtsoftware.Helpers.AssetLoader;


import java.awt.font.GraphicAttribute;
import java.util.Random;

/**
 * Created by Jonty on 24/08/2015.
 */
public class GameRenderer {
    private SpriteBatch batcher;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    BitmapFont font;
    private Texture testCard;
    GameWorld world;
    private UITest uitest;

    public GameRenderer(GameWorld world, float gameHeight){
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);
       // cam.rotate(0.45f);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);






//        FreeTypeFontGenerator generator = new FreeTypeFontGEnerator();
//        font = new BitmapFont(Gdx.files.internal("Papy.fnt"));

    }

    public void render(float delta){

        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, .5f);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        int row = 0;
        boolean seizure = false;







        batcher.draw(AssetLoader.title, 10, 26, AssetLoader.title.getRegionWidth() / 4, AssetLoader.title.getRegionHeight() / 4);


        if(world.state == GameWorld.GameState.ROUND){
            world.faceDownCard().draw(batcher);
        }

        batcher.end();


        Gdx.gl.glEnable(GL30.GL_BLEND);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Color swipeColor = world.faceDownCard().getSwipeColor();
        shapeRenderer.setColor(swipeColor);
        shapeRenderer.rect(0, 50, 150, 300);

        shapeRenderer.end();


        batcher.begin();
        batcher.enableBlending();
        // Drawing the corrosponding text to what move is made. (Red left, Black right)
        switch(world.faceDownCard().leftOrRightSwipe()){
            case -1:
                //world.getDialog().drawDialog(batcher);
                switch(world.phase){
                    case REDBLACK:
                        batcher.draw(AssetLoader.red, 64 - AssetLoader.red.getRegionWidth() / 10, 60, AssetLoader.red.getRegionWidth() / 5, AssetLoader.red.getRegionHeight() / 5);
                        break;
                    case UPDOWN:
                        batcher.draw(AssetLoader.lower, 64- AssetLoader.lower.getRegionWidth() /10, 60, AssetLoader.lower.getRegionWidth() /5, AssetLoader.lower.getRegionHeight() /5);
                }break;

            case 1:
                switch(world.phase){
                    case REDBLACK:
                        batcher.draw(AssetLoader.black, 64 - AssetLoader.black.getRegionWidth() / 10, 60, AssetLoader.black.getRegionWidth() / 5, AssetLoader.black.getRegionHeight() / 5);
                        break;

                    case UPDOWN:
                        batcher.draw(AssetLoader.higher, 64 - AssetLoader.higher.getRegionWidth() / 10, 60, AssetLoader.higher.getRegionWidth() / 5, AssetLoader.higher.getRegionHeight() / 5);
                        break;
                }
                break;
            default:
                break;

        }


        if(world.state == GameWorld.GameState.CORRECT || world.state == GameWorld.GameState.INCORRECT){
            batcher.end();
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            Gdx.gl.glEnable(GL30.GL_BLEND);
            shapeRenderer.setColor(0, 0, 0, 0.8f);
            shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            shapeRenderer.end();
            batcher.begin();
            batcher.enableBlending();
            renderDialog();
        }



        batcher.end();



    }

    public void renderDialog(){
        world.getDialog().drawDialog(batcher);
    }
}
