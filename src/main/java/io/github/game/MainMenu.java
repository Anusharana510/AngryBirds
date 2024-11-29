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

public class MainMenu implements Screen {
    private Stage stage; // Stage for UI components (buttons, etc.)
    private SpriteBatch spriteBatch; // Batch to draw textures
    private Texture backgroundTexture; // Background texture for the main menu
    private Texture titleTexture; // Title image of the game
    private Texture birdTexture1, birdTexture2, birdTexture3, birdTexture4; // Bird textures (for future use)
    private Texture pigTexture1, pigTexture2; // Pig textures (for future use)
    private Skin uiSkin; // Skin for UI components (buttons)
    private Skin alternateSkin; // Alternate UI skin
    private TextButton startGameButton; // Button to start the game
    private TextButton settingsButton; // Button to open settings (not used in this code yet)
    private TextButton quitButton; // Button to quit the game
    private AngryBirds game; // Reference to the main game instance

    // Constructor initializing the game reference
    public MainMenu(AngryBirds game) {
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        backgroundTexture = new Texture("menubg.png"); // Main menu background image
        titleTexture = new Texture("name.png"); // Game title image

        // Set up the stage for UI components and input processor
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Load UI skin assets
        uiSkin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        alternateSkin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));

        // Create the "Start Game" button
        startGameButton = new TextButton("Start Game", alternateSkin); // Button text changed
        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to the Levels screen when clicked
                game.setScreen(new LevelsScreen(game));
            }
        });
        startGameButton.setPosition(220, 250); // Adjusted position (more centered)
        startGameButton.setSize(150, 60);
        stage.addActor(startGameButton); // Add button to the stage

        // Create the "Quit" button
        quitButton = new TextButton("Exit Game", alternateSkin); // Button text changed
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit(); // Exit the application when clicked
            }
        });
        quitButton.setPosition(220, 120); // Adjusted position (below the Start Game button)
        quitButton.setSize(150, 60);
        stage.addActor(quitButton); // Add button to the stage
    }

    @Override
    public void render(float delta) {
        // Clear the screen before rendering the UI
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Begin drawing the UI elements
        spriteBatch.begin();
        spriteBatch.draw(backgroundTexture, 10, 10, 620, 450); // Draw background image
        spriteBatch.draw(titleTexture, 170, 290, 300, 150); // Draw title image
        spriteBatch.end();

        // Update and draw the stage elements (UI buttons)
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // Not used in this case, but necessary for handling screen resizing
    }

    @Override
    public void pause() {
        // Not needed for this class, but required by the Screen interface
    }

    @Override
    public void resume() {
        // Not needed for this class, but required by the Screen interface
    }

    @Override
    public void hide() {
        // Not used in this case, but necessary for handling when the screen is hidden
    }

    @Override
    public void dispose() {
        // Dispose of the assets when the screen is no longer needed
        spriteBatch.dispose(); // Dispose of the sprite batch
        backgroundTexture.dispose(); // Dispose of the background texture
        titleTexture.dispose(); // Dispose of the title texture
        stage.dispose(); // Dispose of the stage (all UI components)
        uiSkin.dispose(); // Dispose of the default skin
    }
}
