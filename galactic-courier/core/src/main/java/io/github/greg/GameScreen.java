package io.github.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen {
    private SpriteBatch batch;
    private Ship ship;
    private SpaceStations spaceStations;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float scale = 0.5f;

        batch = new SpriteBatch();

        ship = new Ship("cohete_off.png", screenWidth, screenHeight, scale);
        ship.setX((screenWidth - ship.getWidth() * scale) / 2);
        ship.setY((screenHeight - ship.getHeight() * scale) / 2);

        float randomX = MathUtils.random(0, screenWidth);
        float randomY = MathUtils.random(0, screenHeight);
        scale = 2.5f;
        spaceStations = new SpaceStations("icon_teleporter.png", randomX, randomY, scale);
        spaceStations.setX(randomX - spaceStations.getWidth());
        spaceStations.setY(randomY - spaceStations.getHeight());
    }

    public void update(float delta) {
        ship.update(delta);
        spaceStations.update(delta);
    }

    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        ship.render(batch);
        spaceStations.render(batch);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        ship.dispose();
        spaceStations.dispose();
    }
}
