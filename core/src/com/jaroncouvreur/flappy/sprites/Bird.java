package com.jaroncouvreur.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Jaron on 10/10/2017.
 */

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private final Texture img;
    private final Rectangle bounds;
    private Vector2 position;
    private Vector2 velocity;

    public Bird(float posX, float posY) {
        img = new Texture("bird.png");
        position = new Vector2(posX, posY);
        bounds = new Rectangle(position.x, position.y, img.getWidth(), img.getHeight());
        velocity = new Vector2(0, 0);
    }

    public void update(float dt) {
        velocity.add(0, GRAVITY);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y);
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getImg() {
        return img;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void dispose() {
        img.dispose();
    }
}
