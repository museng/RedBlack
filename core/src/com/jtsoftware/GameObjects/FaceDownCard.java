package com.jtsoftware.GameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jtsoftware.Helpers.AssetLoader;

/**
 * Created by Jonty on 31/08/2015.
 * ..
 */



public class FaceDownCard {

    private String test;

    private boolean pressed;
    private float pressOrigin, x, y;
    private Sprite sprite;
    public FaceDownCard(){
        this.pressed = false;

        this.sprite = new Sprite(AssetLoader.faceDownCard);
        //this.sprite.setRotation((float) 45.0);
//        this.sprite.setRegionWidth(AssetLoader.faceDownCard.getRegionWidth() / 4);
        //this.sprite.setRegionHeight(AssetLoader.faceDownCard.getRegionHeight() / 4);
        sprite.setScale(.25f,.25f);
        sprite.setY(0);
        sprite.setOrigin(125,380);

        reset();


    }

    public void updateCard(float xPressed, float yPressed){

        if(isPressed()){
            System.out.println("card:" + pressOrigin + " : " + this.x);
            this.x = -50 + (xPressed - pressOrigin);
            System.out.println("UPDATED X: " + this.x);

            sprite.setX(x);

            this.sprite.rotate((xPressed - pressOrigin)/100);


        }
        else{

            reset();
        }


    }
    public void draw(SpriteBatch b){

        sprite.draw(b);

        //b.draw(this.sprite,this.x,this.y);
    }
    public void reset(){
        System.out.println("RESET");
        this.x = 50;
        this.y = 100;
        this.sprite.setX(-50);
        this.sprite.setY(-150);
        this.sprite.setRotation(0);

    }

    public boolean isPressed(){

        return pressed;
    }
    public void Unpress(){
        pressed = false;
    }
    public void press(float x){
        this.pressed = true;

        this.pressOrigin = x;



        System.out.println("aa");
        System.out.println(test);

    }


    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public float pressed(){

        return pressOrigin;
    }
}
