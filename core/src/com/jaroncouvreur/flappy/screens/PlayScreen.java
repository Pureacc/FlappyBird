package com.jaroncouvreur.flappy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jaroncouvreur.flappy.FlappyBird;
import com.jaroncouvreur.flappy.sprites.Bird;
import com.jaroncouvreur.flappy.sprites.Ground;
import com.jaroncouvreur.flappy.sprites.Tube;

import java.util.ArrayList;
import java.util.List;

import java8.util.stream.StreamSupport;

/**
 * Created by Jaron on 9/10/2017.
 */

class PlayScreen extends GameScreen {
    private static final int TUBE_COUNT = 4;
    private static final int TUBE_SPACING = 125;
    private final Bird bird;
    private final List<Tube> tubes;
    private final Ground ground;
//    private final Music speech;

    PlayScreen(SpriteBatch batch, ScreenManager screenManager) {
        super(batch, screenManager);
        bird = new Bird(20, 210);
        tubes = new ArrayList<>();
        for (int i = 1; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.WIDTH)));
        }
        ground = new Ground(50);
//        speech = Gdx.audio.newMusic(Gdx.files.internal("speech.mp3"));
//        speech.play();
        cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateCam();
        bird.update(dt);
        ground.update(cam.position.x - cam.viewportWidth / 2);
        updateTubes();
        checkCollision();
    }

    @Override
    public void render(float delta) {
        update(delta);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(background, cam.position.x - cam.viewportWidth / 2, cam.position.y - cam.viewportHeight / 2, cam.viewportWidth, cam.viewportHeight);
        bird.draw(batch);
        StreamSupport.stream(tubes).forEach(t -> t.draw(batch));
        ground.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bird.dispose();
        StreamSupport.stream(tubes).forEach(Tube::dispose);
        ground.dispose();
//        speech.dispose();
    }

    private void checkCollision() {
        Rectangle birdBounds = bird.getBounds();
        if (StreamSupport.stream(tubes).anyMatch(t -> t.collides(birdBounds)) || ground.collides(birdBounds)) {
            screenManager.showGameOverScreen();
        }
    }

    private void updateTubes() {
        StreamSupport.stream(tubes)
                .filter(t -> cam.position.x - cam.viewportWidth / 2 > t.getPosBot().x + t.getBot().getWidth())
                .forEach(t -> t.reposition(t.getPosBot().x + (Tube.WIDTH + TUBE_SPACING) * TUBE_COUNT));
    }

    private void updateCam() {
        cam.position.x = bird.getPosition().x + 130;
        cam.update();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

}
