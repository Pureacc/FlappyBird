package com.jaroncouvreur.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaron on 13/10/2017.
 */

class Animation {
    private final Texture texture;
    private final List<TextureRegion> frames;
    private final float maxFrameTime;
    private float currentFrameTime;
    private int currentFrame;

    Animation(String texturePath, int frameCount, float cycleTime) {
        texture = new Texture(texturePath);
        frames = new ArrayList<>();
        int frameWidth = texture.getWidth() / frameCount;
        for (int i=0; i<frameCount; i++) {
            frames.add(new TextureRegion(texture, i * frameWidth, 0, frameWidth, texture.getHeight()));
        }
        maxFrameTime = cycleTime / frameCount;
        currentFrame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            currentFrame++;
            currentFrameTime = 0;
        }
        if (currentFrame == frames.size()) {
            currentFrame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(currentFrame);
    }

    public float getWidth() {
        return texture.getWidth() / frames.size();
    }

    public float getHeight() {
        return texture.getHeight();
    }

    public void dispose(){
        texture.dispose();
    }
}
