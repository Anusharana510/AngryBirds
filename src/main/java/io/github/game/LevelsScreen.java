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

public class LevelsScreen implements Screen {
    private Stage stage_;
    private SpriteBatch batch;
    private Texture background;
    private Skin skin;
    private TextButton level1;
    private TextButton level2;
    private TextButton level3;
    private TextButton level4;
    private TextButton back;
    private BitmapFont font_;
    private Skin skin1;

    private AngryBirds game;
    public LevelsScreen(AngryBirds game){
        this.game = game;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        font_ = new BitmapFont();
        background = new Texture("pausebg.jpg");

        stage_ = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage_);

        skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        skin1 = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        level1 = new TextButton("Easy Level",skin);
        level1.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new EasyLevel(game));
            }
        });
        level1.setPosition(250,340);
        level1.setSize(150,60);
        stage_.addActor(level1);

        level2 = new TextButton("Medium Level",skin);
        level2.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MediumLevel(game));
            }
        });
        level2.setPosition(250,260);
        level2.setSize(150,60);
        stage_.addActor(level2);

        level3 = new TextButton("HardLevel ",skin);
        level3.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new HardLevel(game));
            }
        });
        level3.setPosition(250,180);
        level3.setSize(150,60);
        stage_.addActor(level3);

        back = new TextButton("Back",skin1);
        back.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MainMenu(game));
            }
        });
        back.setPosition(35,20);
        back.setSize(50,50);
        stage_.addActor(back);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background,10,10,620,450);

        font_.setColor(1,1,1,1);
        font_.draw(batch,"Select Your Level -",260,430);

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
        skin.dispose();
    }
}
