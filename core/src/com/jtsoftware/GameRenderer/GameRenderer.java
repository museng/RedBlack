package com.jtsoftware.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jtsoftware.GameWorld.GameWorld;
import com.jtsoftware.Helpers.AssetLoader;


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





        world.faceDownCard().draw(batcher);

        batcher.draw(AssetLoader.title, 10, 26, AssetLoader.title.getRegionWidth() / 4, AssetLoader.title.getRegionHeight() / 4);




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

                batcher.draw(AssetLoader.red, 64 - AssetLoader.red.getRegionWidth()/10, 60, AssetLoader.red.getRegionWidth()/5, AssetLoader.red.getRegionHeight()/5);
                break;
            case 1:
                batcher.draw(AssetLoader.black, 64 -AssetLoader.black.getRegionWidth() /10, 60, AssetLoader.black.getRegionWidth()/5, AssetLoader.black.getRegionHeight()/5);
                break;
            default:
                break;

        }

        batcher.end();




    }
}
