package com.jtsoftware.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jtsoftware.Helpers.AssetLoader;



/**
 * Created by Jonty on 31/08/2015.
 * ..
 */



public class FaceDownCard {

    private String test;

    private int swipeLeftOrRight; // -1 for left swiped, 1 for right swipe, 0 for neither.

    private boolean pressed;
    private boolean pressedBottom;
    private float pressOriginX, pressOriginY, x, y, screenX, screenY;
    private Sprite sprite;
    private Color swipeColor;
    private float swipeDistance;

    public FaceDownCard(final float screenX,final float screenY){
        this.pressed = false;
        this.screenX = screenX;
        this.screenY = screenY;
        this.sprite = new Sprite(AssetLoader.faceDownCard);
        //this.sprite.setRotation((float) 45.0);
//        this.sprite.setRegionWidth(AssetLoader.faceDownCard.getRegionWidth() / 4);
        //this.sprite.setRegionHeight(AssetLoader.faceDownCard.getRegionHeight() / 4);
        sprite.setScale(.3f,.3f);
        sprite.setY(250);
        sprite.setOrigin(this.sprite.getWidth()/2,this.sprite.getHeight()/2);

        reset();


    }

    public void updateCard(float xPressed, float yPressed){

        if(isPressed()){

            this.swipeDistance = (xPressed - pressOriginX);

            this.x = (this.screenX /2) + swipeDistance; //usually -50

            this.y = ((this.screenY / 3) * 2) + (yPressed - pressOriginY); // usually -150.
//            sprite.setX(x);
//            sprite.setY(y);
                sprite.setCenter(x, y);
//            this.sprite.rotate((xPressed - pressOrigin) / 100);
            if(!pressedBottom)this.sprite.setRotation(swipeDistance/4); //originally 3
            else this.sprite.setRotation(-(swipeDistance/4));
            //System.out.println("ROTATION: " + this.sprite.getRotation() + "xPressed:"+xPressed+"pressOrigin:"+pressOriginX);


        }
        else{

            reset();
        }


    }
    public void draw(SpriteBatch b){

        sprite.draw(b);



    }
    public int leftOrRightSwipe(){

        if(swipeDistance < -50){
            return -1;
        }
        else if(swipeDistance > 50){
            return 1;

        }
        return 0;


    }
    public void reset(){
        System.out.println("RESET");
        this.x = this.screenX /2;
        this.y = (this.screenY / 3) * 2;
//
        this.sprite.setCenter(this.x, this.y );
        this.sprite.setRotation(0);

    }

    public boolean isPressed(){

        return pressed;
    }
    public void Unpress(){
        swipeDistance = 0;
        pressed = false;
    }
    public void press(float x, float y){
        this.pressed = true;
        if(y >  200){
            pressedBottom = true;
        }else pressedBottom = false;
        this.pressOriginX = x;
        this.pressOriginY = y;






    }


    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public float pressed(){

        return pressOriginX;
    }

    public Color getSwipeColor() {

        float angle = swipeDistance;
        angle = (1/(50/angle));
        if(angle < 0){
            swipeColor = new Color(1,0,0,Math.abs(angle));
        }
        else{
            swipeColor = new Color(0,0,0,Math.abs(angle));
        }
        return swipeColor;
    }


}
