package com.jtsoftware.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.jtsoftware.GameWorld.GameWorld;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Created by Jonty on 23/08/2015.
 */
public class InputHandler implements InputProcessor {
    private GameWorld world;
    private float scaleFactorX;
    private float scaleFactorY;
    private Vector2 lastTouch;

    public InputHandler(GameWorld world, float scaleFactorX, float scaleFactorY, ActionResolver resolver){
        this.world = world;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

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

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        world.faceDownCard().press(screenX, screenY);

        //System.out.println(world.isPhaseRedBlack());



        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if(world.state == GameWorld.GameState.CORRECT || world.state == GameWorld.GameState.INCORRECT){

            world.updateGamePhase();
        }
        else{
            System.out.println("Unpressed!");
            if(world.faceDownCard().isPressed()){
                if(world.faceDownCard().leftOrRightSwipe() == -1){
                    world.choice.setChoice(0);
                    world.state = GameWorld.GameState.CARDPICKED;
                }
                else if(world.faceDownCard().leftOrRightSwipe() == 1){
                    world.choice.setChoice(1);
                    world.state = GameWorld.GameState.CARDPICKED;
                }

                world.faceDownCard().Unpress();
                world.faceDownCard().reset();

            }
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //System.out.println("draaaagged + " + screenX);
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if(world.state == GameWorld.GameState.ROUND){

            if(world.faceDownCard().isPressed()){

                world.faceDownCard().updateCard(screenX, screenY);

            }
            /*
            else{
                world.faceDownCard().press(screenX);
            }
            */
        }
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

    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }
}
