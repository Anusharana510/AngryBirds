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
import io.github.game.AngryBirds;

public class SplashScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage_;
    private Texture image;
    private Texture name;
    private Texture image1;
    private Texture image2;
    private Texture image3;
    private Texture image4;
    private Texture image5;
    private Texture image6;
    private Texture pig1;
    private Texture pig2;
    private Texture pig3;
    private Skin skin;
    private Skin skin1;
    private TextButton play_button;
    private AngryBirds game;

    public SplashScreen(AngryBirds game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("splash.png");
        name = new Texture("name.png");


        stage_ = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage_);

        skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        skin1 = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        play_button = new TextButton("Start",skin1);
        play_button.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MainMenu(game));
            }
        });
        play_button.setPosition(230,30);
        play_button.setSize(150,60);
        stage_.addActor(play_button);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image,10,10,620,450);
        batch.draw(name,150,250,400,180);
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
        image.dispose();
        stage_.dispose();
        skin.dispose();
    }
}
