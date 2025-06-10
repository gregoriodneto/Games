package io.github.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Ship extends Base {
    private ShipState state;
    private int points = 0;
    private OrthographicCamera camera;

    public Ship(String imagePath, float x, float y, float scale, ShipState state, OrthographicCamera camera) {
        super(imagePath, x, y, scale);
        this.state = state;
        this.camera = camera;
    }

    public void touchMovimentShip() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                Vector3 touchPos = new Vector3(screenX, screenY, 0);
                camera.unproject(touchPos);

                setX(touchPos.x - getWidth() * getScale() / 2);
                setY(touchPos.y - getHeight() * getScale() / 2);

                return true;
            }
        });
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) setX(getX() - 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) setX(getX() + 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) setY(getY() + 200 * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) setY(getY() - 200 * delta);

        if (getX() < 0) setX(0);
        if (getY() < 0) setY(0);
        if (getX() > Gdx.graphics.getWidth() - getWidth() * getScale()) setX(Gdx.graphics.getWidth() - getWidth() * getScale());
        if (getY() > Gdx.graphics.getHeight() - getHeight() * getScale()) setY(Gdx.graphics.getHeight() - getHeight() * getScale());
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
