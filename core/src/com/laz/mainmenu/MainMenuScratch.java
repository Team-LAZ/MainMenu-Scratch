package com.laz.mainmenu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//https://github.com/libgdx/libgdx/wiki/Extending-the-simple-game

public class MainMenuScratch extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    private MainMenuScreen mainMenuScreen;
    private OptionsScreen optionsScreen;
    private ControlsScreen controlsScreen;

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        setMainMenuScreen();
    }

    public void setMainMenuScreen() {
        mainMenuScreen = new MainMenuScreen(this);
        this.setScreen(mainMenuScreen);
    }

    public void setOptionsScreen() {
        optionsScreen = new OptionsScreen(this);
        this.setScreen(optionsScreen);
    }

    public void setControlsMenu() {
        controlsScreen = new ControlsScreen(this);
        this.setScreen(controlsScreen);
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}