package com.jtsoftware.redorblack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jtsoftware.Helpers.ActionResolver;
import com.jtsoftware.Helpers.AssetLoader;

public class RoB extends Game {
	ActionResolver resolver;
	public RoB(ActionResolver resolver){
		this.resolver = resolver;
	}
	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new SplashScreen(this,resolver));

	}

	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
}
