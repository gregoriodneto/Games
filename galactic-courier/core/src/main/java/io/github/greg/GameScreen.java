package io.github.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen {
    private Ship ship;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float scale = 0.5f;

        ship = new Ship("cohete_off.png", screenWidth, screenHeight, scale);
        ship.setX((screenWidth - ship.getWidth() * scale) / 2);
        ship.setY((screenHeight - ship.getHeight() * scale) / 2);
    }

    public void update(float delta) {
        ship.update(delta);
    }

    public void render() {
        ship.render();
    }

    public void dispose() {
        ship.dispose();
    }
}
