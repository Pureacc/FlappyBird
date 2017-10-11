package com.jaroncouvreur.flappy.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jaroncouvreur.flappy.FlappyBird;

/**
 * Created by Jaron on 10/10/2017.
 */

abstract class GameScreen extends ScreenAdapter {
    protected final SpriteBatch batch;
    protected final ScreenManager screenManager;
    protected final OrthographicCamera cam;
    protected final Texture background;

    protected GameScreen(SpriteBatch batch, ScreenManager screenManager) {
        this.batch = batch;
        this.screenManager = screenManager;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        background = new Texture("bg.png");
    }

    public abstract void update(float dt);

    @Override
    public void dispose() {
        background.dispose();
    }
}
