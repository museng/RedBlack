package com.jtsoftware.redorblack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.jtsoftware.GameRenderer.GameRenderer;
import com.jtsoftware.GameWorld.GameWorld;
import com.jtsoftware.Helpers.ActionResolver;

/**
 * Created by Jonty on 23/08/2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;

    private GameRenderer renderer;

    private float runTime;

    ActionResolver resolver;

    public GameScreen(ActionResolver resolver){


        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        this.resolver = resolver;

        int midPointY = (int) (gameHeight / 2);
        world = new GameWorld(resolver);
        renderer = new GameRenderer(world, (int) gameHeight);
        world.setRenderer(renderer);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta){

        runTime += delta;
        world.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
