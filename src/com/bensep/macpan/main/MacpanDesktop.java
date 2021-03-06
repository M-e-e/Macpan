package com.bensep.macpan.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MacpanDesktop {

    public static void main(String[] args){
        LwjglApplicationConfiguration cfg =
                new LwjglApplicationConfiguration();

        cfg.title = Game.TITLE;
        cfg.width = Game.V_WIDTH * Game.SCALE;
        cfg.height = Game.V_HEIGHT * Game.SCALE;
        cfg.foregroundFPS = 60;
        cfg.backgroundFPS = 1;
        cfg.vSyncEnabled = true;
        new LwjglApplication(new Game(), cfg);
    }



}
