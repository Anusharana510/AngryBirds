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

public class GameScreen implements Screen {
    private Stage stage_;
    private SpriteBatch batch;
    private BitmapFont font_;
    private Texture background;
    private Texture slingshot;
    private Texture bird1;
    private Texture bird2;
    private Texture bird3;
    private Texture bird4;
    private Texture bird5;
    private Texture pig_stand;
    private Skin skin1;
    private TextButton pause;
    private TextButton end_level;

    private AngryBirds game;
    public GameScreen(AngryBirds game){
        this.game = game;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        font_ = new BitmapFont();
        background = new Texture("grd.jpg");
        slingshot = new Texture("sling.png");
        bird1 = new Texture("bird.png");
        bird2 = new Texture("bird2.png");
        bird3 = new Texture("bird3.png");
        bird4 = new Texture("bird4.png");
        //bird5 = new Texture("5.png");
        pig_stand = new Texture("block.jpeg");

        stage_ = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage_);

        skin1 = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        pause = new TextButton("Pause",skin1);
        pause.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new PauseScreen(game));
            }
        });
        pause.setPosition(30,400);
        pause.setSize(80,40);
        stage_.addActor(pause);

        end_level = new TextButton("Finish",skin1);
        end_level.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x,float y){
                game.setScreen((new LevelEnd(game)));
            }
        });
        end_level.setPosition(260,25);
        end_level.setSize(80,40);
        stage_.addActor(end_level);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background,10,10,620,450);
        batch.draw(slingshot,130,80,100,200);
        batch.draw(bird1,130,150,55,55);
        batch.draw(bird2,150,55,55,55);
        batch.draw(bird3,110,55,55,55);
        batch.draw(bird4,70,55,55,55);
        batch.draw(bird5,30,55,55,55);
        batch.draw(pig_stand,400,80,200,380);

        font_.setColor(1,1,1,1);
        font_.draw(batch,"SCORE : 0",540,450);

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
