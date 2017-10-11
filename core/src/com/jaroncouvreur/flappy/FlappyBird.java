package com.jaroncouvreur.flappy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jaroncouvreur.flappy.screens.ScreenManager;

public class FlappyBird extends Game {
    public static final String TITLE = "Flappy Bird";
    public static final int WIDTH = 600;
    public static final int HEIGHT = 840;
    private SpriteBatch batch;
    private ScreenManager screenManager;

    @Override
    public void create () {
        batch = new SpriteBatch();
        screenManager = new ScreenManager(this);
        screenManager.showMenuScreen();
    }

    @Override
    public void render() {
        super.render();
        screenManager.disposeIdleScreens();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
