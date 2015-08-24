package com.jtsoftware.redorblack.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jtsoftware.redorblack.RoB;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Red | Black";
//		cfg.useGL20 = false;
		config.width = 1080 / 3;
		config.height = 1920 / 3;
		new LwjglApplication(new RoB(null), config);
	}
}
