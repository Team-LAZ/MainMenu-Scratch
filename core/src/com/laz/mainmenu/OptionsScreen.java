package com.laz.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OptionsScreen implements Screen {

    final MainMenuScratch game;
    OrthographicCamera camera;
    Stage stage;
    BitmapFont font;
    Skin skin;
    Pixmap pixmap;
    TextButtonStyle textButtonStyle;
    TextButton btnSound, btnControls, btnBack;

    Preferences prefOptions;
    boolean bSound = true;

    public OptionsScreen(final MainMenuScratch game) {
        this.game = game;

        prefOptions = Gdx.app.getPreferences("options");
        bSound = prefOptions.getBoolean("sound");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();

        skin = new Skin();
        skin.add("default", font);

        pixmap = new Pixmap(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        if (bSound) btnSound = new TextButton("Sound - ON", skin);
        else btnSound = new TextButton("Sound - OFF", skin);
        btnSound.setPosition(Gdx.graphics.getWidth() / 2 - 250, Gdx.graphics.getHeight() / 2 + 75);
        stage.addActor(btnSound);

        btnControls = new TextButton("Controls", skin);
        btnControls.setPosition(Gdx.graphics.getWidth() / 2 + 50, Gdx.graphics.getHeight() / 2 + 75);
        stage.addActor(btnControls);

        btnBack = new TextButton("Back", skin);
        btnBack.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2);
        stage.addActor(btnBack);

        btnSound.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                toggleSound();
            }
        });

        btnControls.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                controls();
            }
        });

        btnBack.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setMainMenuScreen();
            }
        });
    }

    public void toggleSound() {
        if (bSound) {
            bSound = false;
            btnSound.setText("Sound - OFF");
            prefOptions.putBoolean("sound", bSound);
        } else {
            bSound = true;
            btnSound.setText("Sound - ON");
            prefOptions.putBoolean("sound", bSound);
        }
        prefOptions.flush();
    }

    public void controls() {
        game.setControlsMenu();
    }

    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "OPTIONS", Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 + 175);
        game.batch.end();

        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
