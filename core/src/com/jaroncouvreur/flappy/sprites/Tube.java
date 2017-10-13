package com.jaroncouvreur.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Jaron on 10/10/2017.
 */

public class Tube {
    public static final int WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Texture bot, top;
    private Rectangle boundsBot, boundsTop;
    private Vector2 posBot, posTop;
    private Random rand;

    public Tube(float x) {
        bot = new Texture("bottomtube.png");
        top = new Texture("toptube.png");
        rand = new Random();
        posTop = new Vector2(x, rand.nextInt(FLUCTUATION) + GAP + LOWEST_OPENING);
        posBot = new Vector2(x, posTop.y - GAP - bot.getHeight());
        boundsBot = new Rectangle(posBot.x, posBot.y, bot.getWidth(), bot.getHeight());
        boundsTop = new Rectangle(posTop.x, posTop.y, top.getWidth(), top.getHeight());
    }

    public void reposition(float x) {
        posTop.set(x, rand.nextInt(FLUCTUATION) + GAP + LOWEST_OPENING);
        posBot.set(x, posTop.y - GAP - bot.getHeight());
        boundsTop.setPosition(posTop.x, posTop.y);
        boundsBot.setPosition(posBot.x, posBot.y);
    }

    public boolean collides(Rectangle player) {
        return boundsBot.overlaps(player) || boundsTop.overlaps(player);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(bot, posBot.x, posBot.y);
        batch.draw(top, posTop.x, posTop.y);
    }

    public Texture getBot() {
        return bot;
    }

    public Vector2 getPosBot() {
        return posBot;
    }

    public void dispose() {
        bot.dispose();
        top.dispose();
    }
}
