//package io.github.game;
//
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//
//public class AngryBirds extends Game {
//    public SpriteBatch spriteBatch; // Responsible for drawing images to the screen
//    public float worldWidth; // Width of the world space (for scaling)
//    public float worldHeight; // Height of the world space (for scaling)
//    private OrthographicCamera camera; // Camera to view the world
//    private Viewport viewport; // Viewport for scaling the game to different screen sizes
//    private Music backgroundMusic; // Music that plays in the background
//    private boolean isMusicPlaying = true; // Keeps track if music is playing
//
//    @Override
//    public void create() {
//        // This method is called once when the game starts
//
//        // Initialize the sprite batch (used to draw objects on the screen)
//        spriteBatch = new SpriteBatch();
//
//        // Set the initial screen to SplashScreen
//        setScreen(new io.github.game.MainMenu(this));
//
//        // Initialize the camera to view the game world
//        camera = new OrthographicCamera();
//
//        // Initialize the viewport for scaling the world to fit the screen size
//        viewport = new FitViewport(worldWidth, worldHeight, camera);
//        viewport.apply(); // Apply the viewport settings
//
//        // Position the camera at the center of the world space
//        camera.position.set(worldWidth / 640, worldHeight / 480, 0);
//
//        // Load and play background music, looping it
//        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
//        backgroundMusic.setLooping(true);
//        backgroundMusic.play();
//    }
//
//    public void clearScreen() {
//        // This method clears the screen before each render
//        Gdx.gl.glClearColor(0, 0, 0, 1); // Set the clear color to black
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
//    }
//
//    public void toggleMusic() {
//        // This method toggles the background music on and off
//        if (isMusicPlaying) {
//            backgroundMusic.pause(); // Pause music
//        } else {
//            backgroundMusic.play(); // Play music
//        }
//        isMusicPlaying = !isMusicPlaying; // Flip the music status
//    }
//
//    public OrthographicCamera getCamera() {
//        // Returns the camera object
//        return camera;
//    }
//
//    public boolean isScreenTouched() {
//        // This method checks if the screen is touched or if the mouse button is pressed
//        return Gdx.input.isTouched() || Gdx.input.isButtonPressed(Input.Buttons.LEFT);
//    }
//
//    public Vector2 getTouchCoordinates() {
//        // This method returns the touch position in world coordinates
//        Vector2 touchPosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());
//        viewport.unproject(touchPosition); // Convert screen coordinates to world coordinates
//        return touchPosition;
//    }
//
//    @Override
//    public void render() {
//        // This method is called every frame to render the game
//
//        // Clear the screen before drawing
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        // Begin drawing using the sprite batch
//        spriteBatch.begin();
//
//        // Here you can add other objects to draw on the screen (e.g., your main menu or level)
//
//        // End the drawing process
//        spriteBatch.end();
//
//        // Call the render method of the currently active screen (e.g., SplashScreen, MainMenu, etc.)
//        super.render();
//    }
//
//    @Override
//    public void dispose() {
//        // This method is called when the game is closed, so we dispose of the resources
//        spriteBatch.dispose(); // Dispose of the sprite batch to free memory
//        backgroundMusic.dispose(); // Dispose of the background music resource
//    }
//}
package io.github.game;

//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import org.angry.view.LevelsScreen;
//import org.angry.view.MainMenu;
//import org.angry.view.EasyLevel;
//import org.angry.view.splash;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class AngryBirds extends Game {

    public static boolean isOneDarged = false;
    public final static int V_WIDTH = 1280;
    public final static int V_HIEGHT = 560;
    public static MainMenu main = null;
    public static SplashScreen splash = null;
    public static EasyLevel play = null;
    public static LevelsScreen levelScreen = null;
    private Music backgroundMusic; // Music that plays in the background
    private boolean isMusicPlaying = true;

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        main = new MainMenu(this);
        splash = new SplashScreen(this);
        play = new EasyLevel(this);
        levelScreen = new LevelsScreen(this);
        setScreen(splash);
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
//
    }

    @Override
    public void render() {
        super.render();
    }

    public void toggleMusic() {
        // This method toggles the background music on and off
        if (isMusicPlaying) {
            backgroundMusic.pause(); // Pause music
        } else {
            backgroundMusic.play(); // Play music
        }
        isMusicPlaying = !isMusicPlaying; // Flip the music status
    }
}

