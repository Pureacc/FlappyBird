package com.jaroncouvreur.flappy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jaroncouvreur.flappy.FlappyBird;

/**
 * Created by Jaron on 9/10/2017.
 */

class MenuScreen extends GameScreen {
    private final Texture playBtn;

    MenuScreen(SpriteBatch batch, ScreenManager screenManager) {
        super(batch, screenManager);
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(float delta) {
        update(delta);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        batch.draw(playBtn, FlappyBird.WIDTH / 2 - playBtn.getWidth() / 2, FlappyBird.HEIGHT / 2 - playBtn.getHeight() / 2);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        playBtn.dispose();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            screenManager.showPlayScreen();
        }
    }
}
