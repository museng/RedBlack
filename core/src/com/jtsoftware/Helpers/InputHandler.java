package com.jtsoftware.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.jtsoftware.GameWorld.GameWorld;

/**
 * Created by Jonty on 23/08/2015.
 */
public class InputHandler implements InputProcessor {
    private GameWorld myWorld;
    private float scaleFactorX;
    private float scaleFactorY;
    private Vector2 lastTouch;

    public InputHandler(GameWorld myWorld, float scaleFactorX, float scaleFactorY, ActionResolver resolver){


    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
