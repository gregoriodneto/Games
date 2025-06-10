package io.github.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship extends Base {
    private ShipState state;
    private int points = 0;

    public Ship(String imagePath, float x, float y, float scale, ShipState state) {
        super(imagePath, x, y, scale);
        this.state = state;
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) setX(getX() - 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) setX(getX() + 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) setY(getY() + 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) setY(getY() - 200 * delta);
    }

    public ShipState getState() {
        return state;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
