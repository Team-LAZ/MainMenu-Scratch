package com.laz.mainmenu.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laz.mainmenu.MainMenuScratch;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Main Menu Scratch";
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new MainMenuScratch(), config);
    }
}
