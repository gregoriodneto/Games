package io.github.greg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen {
    private Ship ship;

    public GameScreen() {
        ship = new Ship("cohete_off.png", 140, 210, 0.5f);
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
