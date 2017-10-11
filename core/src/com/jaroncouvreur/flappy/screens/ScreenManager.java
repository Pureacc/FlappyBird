package com.jaroncouvreur.flappy.screens;

import com.badlogic.gdx.Screen;
import com.jaroncouvreur.flappy.FlappyBird;

/**
 * Created by Jaron on 10/10/2017.
 */

public class ScreenManager {
    private final FlappyBird game;
    private Screen previousScreen;

    public ScreenManager(FlappyBird game) {
        this.game = game;
    }

    public void showMenuScreen() {
        showScreen(new MenuScreen(game.getBatch(), this));
    }

    public void showPlayScreen() {
        showScreen(new PlayScreen(game.getBatch(), this));
    }

    public void showGameOverScreen() {
        showScreen(new GameOverScreen(game.getBatch(), this));
    }

    private void showScreen(Screen screen) {
        previousScreen = game.getScreen();
        game.setScreen(screen);
    }

    public void disposeIdleScreens() {
        if (previousScreen != null) {
            previousScreen.dispose();
            previousScreen = null;
        }
    }

}
