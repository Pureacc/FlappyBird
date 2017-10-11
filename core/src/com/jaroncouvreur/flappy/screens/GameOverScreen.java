package com.jaroncouvreur.flappy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jaroncouvreur.flappy.FlappyBird;

/**
 * Created by Jaron on 11/10/2017.
 */

class GameOverScreen extends GameScreen {
    private final Texture restartBtn;

    GameOverScreen(SpriteBatch batch, ScreenManager screenManager) {
        super(batch, screenManager);
        restartBtn = new Texture("restartbtn.png");
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.justTouched()) {
            screenManager.showPlayScreen();
        }
    }

    @Override
    public void render(float delta) {
        update(delta);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        batch.draw(restartBtn, FlappyBird.WIDTH / 2 - restartBtn.getWidth() / 2, FlappyBird.HEIGHT / 2 - restartBtn.getHeight() / 2);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        restartBtn.dispose();
    }
}
