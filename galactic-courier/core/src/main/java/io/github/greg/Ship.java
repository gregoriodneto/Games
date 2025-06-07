package io.github.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship extends Base {
    public Ship(String imagePath, float x, float y, float scale) {
        super(imagePath, x, y, scale);
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) setX(getX() - 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) setX(getX() + 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) setY(getY() + 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) setY(getY() - 200 * delta);
    }
}
