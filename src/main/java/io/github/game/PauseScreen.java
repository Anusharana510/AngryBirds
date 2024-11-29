package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseScreen implements Screen {
    private Stage stage_;
    private SpriteBatch batch;
    private Skin skin1;
    private Texture background;
    private TextButton Resume_button;
    private TextButton Exit_button;

    private AngryBirds game;
    public PauseScreen(AngryBirds game){
        this.game = game;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("pausebg.jpg");


        stage_ = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage_);

        skin1 = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        Resume_button = new TextButton("Resume",skin1);
        Resume_button.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new LevelsScreen(game));
            }
        });
        Resume_button.setPosition(250,270);
        Resume_button.setSize(100,100);
        stage_.addActor(Resume_button);

        Exit_button = new TextButton("Exit Game",skin1);
        Exit_button.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MainMenu(game));
            }
        });
        Exit_button.setPosition(250,150);
        Exit_button.setSize(100,100);
        stage_.addActor(Exit_button);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background,10,10,620,450);

        batch.end();

        stage_.act();
        stage_.draw();
    }

    @Override
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
        batch.dispose();
        background.dispose();
    }
}
