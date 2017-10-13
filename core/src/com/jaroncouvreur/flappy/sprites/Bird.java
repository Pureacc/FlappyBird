package com.jaroncouvreur.flappy.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Jaron on 10/10/2017.
 */

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private final Rectangle bounds;
    private final Sound jumpSnd;
    private final Animation animation;
    private Vector2 position;
    private Vector2 velocity;

    public Bird(float posX, float posY) {
        position = new Vector2(posX, posY);
        velocity = new Vector2(0, 0);
        jumpSnd = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
        animation = new BirdAnimation();
        bounds = new Rectangle(position.x, position.y, animation.getWidth(), animation.getHeight());
    }

    public void update(float dt) {
        animation.update(dt);
        velocity.add(0, GRAVITY);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y);
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
        jumpSnd.play();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(animation.getFrame(), position.x, position.y);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void dispose() {
        animation.dispose();
        jumpSnd.dispose();
    }
}
