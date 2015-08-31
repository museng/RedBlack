package com.jtsoftware.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        int row = 0;
        boolean seizure = false;


        if(!seizure) {
            for (int i = 0; i < 15; i++) {

                if ((i > 2) && (i % 3 == 0)) row++;
                batcher.draw(AssetLoader.cards[i], ((i % 3) * 50), (row * 80), AssetLoader.cards[i].getRegionWidth() / 6, AssetLoader.cards[i].getRegionHeight() / 6);
                //System.out.println("pasting card at i="+(i*40)+" y=" + (j*80) + "res="+AssetLoader.cards[i].getRegionWidth()/6+"x"+AssetLoader.cards[i].getRegionHeight()/6);


            }
        }
        else{
            int x = new Random().nextInt(100);
            int y = new Random().nextInt(300);
            int c = new Random().nextInt(15);
            batcher.draw(AssetLoader.cards[c], x, y, AssetLoader.cards[c].getRegionWidth() / 6, AssetLoader.cards[c].getRegionHeight() / 6);

        }

        world.faceDownCard().draw(batcher);

        batcher.end();



    }
}
