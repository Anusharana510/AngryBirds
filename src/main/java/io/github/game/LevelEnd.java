package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelEnd implements Screen {
    private Stage stage_;
    private SpriteBatch batch;
    private Skin skin1;
    private Texture background;
    private TextButton Next_level;
    private TextButton Exit_game;
    private BitmapFont font_;

    private AngryBirds game;
    public LevelEnd(AngryBirds game){
        this.game = game;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        font_ = new BitmapFont();
        background = new Texture("menubg.png");

        stage_ = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage_);

        skin1 = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        Next_level = new TextButton("Next Level",skin1);
        Next_level.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new LevelsScreen(game));
            }
        });
        Next_level.setPosition(250,270);
        Next_level.setSize(100,100);
        stage_.addActor(Next_level);

        Exit_game = new TextButton("Exit Game",skin1);
        Exit_game.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MainMenu(game));
            }
        });
        Exit_game.setPosition(250,150);
        Exit_game.setSize(100,100);
        stage_.addActor(Exit_game);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background,10,10,620,450);

        font_.setColor(1,1,1,1);
        font_.draw(batch,"You won",260,430);

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
        stage_.dispose();
        skin1.dispose();
        font_.dispose();
    }
}
