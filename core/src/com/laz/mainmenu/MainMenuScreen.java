package com.laz.mainmenu;

import com.badlogic.gdx.Gdx;
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

//http://www.tempoparalelo.com/blog/?p=76
//http://stackoverflow.com/questions/15731944/libgdx-why-is-my-button-not-responding-on-mouseclicks

public class MainMenuScreen implements Screen {

    final MainMenuScratch game;

    OrthographicCamera camera;
    Stage stage;
    BitmapFont font;
    Skin skin;
    Pixmap pixmap;
    TextButtonStyle textButtonStyle;
    TextButton btnNewGame, btnLoad, btnOptions, btnExit;

    public MainMenuScreen(final MainMenuScratch game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Data.WIDTH, Data.HEIGHT);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();

        skin = new Skin();
        skin.add("default", font);

        pixmap = new Pixmap(Data.WIDTH / 4, Data.HEIGHT / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        btnNewGame = new TextButton("New Game", skin);
        btnNewGame.setPosition(Data.WIDTH / 2 - Data.WIDTH / 8, Data.HEIGHT / 2 + 75);
        stage.addActor(btnNewGame);

        btnLoad = new TextButton("Load", skin);
        btnLoad.setPosition(Data.WIDTH / 2 - Data.WIDTH / 8, Data.HEIGHT / 2);
        stage.addActor(btnLoad);

        btnOptions = new TextButton("Options", skin);
        btnOptions.setPosition(Data.WIDTH / 2 - Data.WIDTH / 8, Data.HEIGHT / 2 - 75);
        stage.addActor(btnOptions);

        btnExit = new TextButton("Exit", skin);
        btnExit.setPosition(Data.WIDTH / 2 - Data.WIDTH / 8, Data.HEIGHT / 2 - 150);
        stage.addActor(btnExit);

        btnNewGame.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                newGame();
            }
        });

        btnLoad.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                load();
            }
        });

        btnOptions.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                options();
            }
        });

        btnExit.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

    public void newGame() {

    }

    public void load() {

    }

    public void options() {

    }

    public void show() {

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "LAZY KNIGHT", Data.WIDTH / 2 - 45, Data.HEIGHT / 2 + 175);
        game.batch.end();

        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void hide() {

    }

    public void dispose() {

    }
}

