package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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

public class MediumLevelWin implements Screen {
    private Stage stage_;
    private SpriteBatch batch;
    private Skin skin1;
    private Texture background;
    private TextButton Next_Level;
    private TextButton Quit;
    private BitmapFont font;

    private AngryBirds game;
    public MediumLevelWin(AngryBirds game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("pausebg.jpg");

        stage_ = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage_);

        skin1 = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        font = new BitmapFont(Gdx.files.internal("w.fnt"));
        font.getData().setScale(2f);
        font.setColor(Color.RED);

        Next_Level = new TextButton("Next Level",skin1);
        Next_Level.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new HardLevel(game));
            }
        });
        Next_Level.setPosition(250,270);
        Next_Level.setSize(100,100);
        stage_.addActor(Next_Level);

        Quit = new TextButton("Quit",skin1);
        Quit.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MainMenu(game));
            }
        });
        Quit.setPosition(250,150);
        Quit.setSize(100,100);
        stage_.addActor(Quit);
    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background,10,10,620,450);

        String message = "You Win";
        font.draw(batch, message, 190, 450);

        batch.end();

        stage_.act();
        stage_.draw();
    }

    @Override
    public void resize(int i, int i1) {

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
        font.dispose();
    }
}
