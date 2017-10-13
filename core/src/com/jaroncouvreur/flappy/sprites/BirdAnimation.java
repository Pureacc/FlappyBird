package com.jaroncouvreur.flappy.sprites;

/**
 * Created by Jaron on 13/10/2017.
 */

class BirdAnimation extends Animation {
    private static final String TEXTURE_PATH = "birdanimation.png";
    private static final int FRAME_COUNT = 3;
    private static final float CYCLE_TIME = 0.5f;

    BirdAnimation() {
        super(TEXTURE_PATH, FRAME_COUNT, CYCLE_TIME);
    }
}
