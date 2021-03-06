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

        textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        btnNewGame = new TextButton("New Game", skin);
        btnNewGame.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2 + 75);
        stage.addActor(btnNewGame);

        btnLoad = new TextButton("Load", skin);
        btnLoad.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2);
        stage.addActor(btnLoad);

        btnOptions = new TextButton("Options", skin);
        btnOptions.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2 - 75);
        stage.addActor(btnOptions);

        btnExit = new TextButton("Exit", skin);
        btnExit.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2 - 150);
        stage.addActor(btnExit);

        //click listeners for buttons
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

    //called when new game is clicked
    public void newGame() {
        System.out.println("New Game");
    }

    //called when load is clicked
    public void load() {
        System.out.println("Load");
    }

    //called when options is clicked
    public void options() {
        System.out.println("Options");
        game.setOptionsScreen();
    }

    //renders strings and buttons onscreen
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "LAZY KNIGHT", Gdx.graphics.getWidth() / 2 - 45, Gdx.graphics.getHeight() / 2 + 175);
        game.batch.end();

        stage.act();
        stage.draw();
    }

    public void show() {

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

