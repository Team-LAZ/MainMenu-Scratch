package com.laz.mainmenu.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.laz.mainmenu.MainMenuScratch;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(800, 480);
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new MainMenuScratch();
    }
}