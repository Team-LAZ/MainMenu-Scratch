package com.laz.mainmenu.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.laz.mainmenu.Data;
import com.laz.mainmenu.MainMenuScratch;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(Data.WIDTH, Data.HEIGHT);
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new MainMenuScratch();
    }
}