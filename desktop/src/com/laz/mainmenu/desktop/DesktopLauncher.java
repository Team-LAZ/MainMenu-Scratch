package com.laz.mainmenu.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laz.mainmenu.Data;
import com.laz.mainmenu.MainMenuScratch;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = Data.WIDTH;
        config.height = Data.HEIGHT;
        new LwjglApplication(new MainMenuScratch(), config);
    }
}
