package com.jtsoftware.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jtsoftware.GameWorld.GameWorld;
import com.jtsoftware.Helpers.AssetLoader;

/**
 * Created by Jonty on 24/08/2015.
 */
public class GameRenderer {
    private SpriteBatch batcher;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private Texture testCard;
    GameWorld world;
    public GameRenderer(GameWorld world, int gameHeight){
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);
       // cam.rotate(0.45f);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

    }

    public void render(float delta){

        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batcher.begin();
        batcher.draw(AssetLoader.testAce, 30, 40, 100, 200);

        batcher.draw(AssetLoader.testAce,0,0,AssetLoader.testAce.getRegionWidth()/5,AssetLoader.testAce.getRegionHeight()/5);
        //System.out.println("test");


        batcher.end();



    }
}
