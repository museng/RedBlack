package com.jtsoftware.GameWorld;

import com.jtsoftware.GameObjects.Deck;
import com.jtsoftware.GameRenderer.GameRenderer;
import com.jtsoftware.Helpers.ActionResolver;

/**
 * Created by Jonty on 24/08/2015.
 */
public class GameWorld {
    private ActionResolver resolver;
    private GameRenderer renderer;
    private Deck deck;

    public GameWorld(ActionResolver resolver){
        this.resolver = resolver;

        deck = new Deck();


    }
    public void update(float delta){

        updateMenu();


    }

    public void updateMenu(){

    }
    public void setRenderer(GameRenderer renderer) {
        this.renderer = renderer;
    }
}
