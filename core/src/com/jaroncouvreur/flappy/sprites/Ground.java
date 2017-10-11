package com.jaroncouvreur.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Jaron on 11/10/2017.
 */

public class Ground {
    private final Texture img;
    private final Vector2 pos1;
    private final Vector2 pos2;
    private final Rectangle bounds;

    public Ground(float y) {
        img = new Texture("ground.png");
        pos1 = new Vector2(0, y - img.getHeight());
        pos2 = new Vector2(pos1.x + img.getWidth(), pos1.y);
        bounds = new Rectangle(pos1.x, pos1.y, 2 * img.getWidth(), img.getHeight());
    }

    public boolean collides(Rectangle player) {
        return bounds.overlaps(player);
    }

    public void update(float camX) {
        if (firstPieceOffscreen(camX)) {
            moveFirstPiece();
        }
        if (secondPieceOffscreen(camX)) {
            moveSecondPiece();
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(img, pos1.x, pos1.y);
        batch.draw(img, pos2.x, pos2.y);
    }

    public void dispose() {
        img.dispose();
    }

    private boolean firstPieceOffscreen(float camX) {
        return pos1.x + img.getWidth() < camX;
    }

    private boolean secondPieceOffscreen(float camX) {
        return pos2.x + img.getWidth() < camX;
    }

    private void moveFirstPiece() {
        pos1.x += 2 * img.getWidth();
        bounds.x = pos2.x;
    }

    private void moveSecondPiece() {
        pos2.x += 2 * img.getWidth();
        bounds.x = pos1.x;
    }
}
