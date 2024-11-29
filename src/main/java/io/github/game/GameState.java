package io.github.game;

import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L; // Version for serialization
    private int currentLevel;
    private int score;
    private boolean[] solvedLevels;
    private float birdX, birdY;
    private float pigX, pigY;// Track solved levels (true = completed)

    // Constructor
    public GameState(int totalLevels) {
        this.solvedLevels = new boolean[totalLevels]; // Initialize levels
    }

    // Getters and Setters
    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean[] getSolvedLevels() {
        return solvedLevels;
    }

    public void setSolvedLevels(boolean[] solvedLevels) {
        this.solvedLevels = solvedLevels;
    }

    public void markLevelSolved(int level) {
        if (level >= 0 && level < solvedLevels.length) {
            solvedLevels[level] = true;
        }
    }
}
