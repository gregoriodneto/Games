package io.github.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class GameScreen {
    private SpriteBatch batch;
    private Ship ship;
    private List<SpaceStations> stations;

    private float screenWidth;
    private float screenHeight;

    private OrthographicCamera camera;

    public GameScreen() {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        float scale = 0.3f;

        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);

        ship = new Ship("cohete_off.png", screenWidth, screenHeight, scale, false, ShipState.NO_LOAD, camera);
        ship.touchMovimentShip();
        ship.setX((screenWidth - ship.getWidth() * scale) / 2);
        ship.setY((screenHeight - ship.getHeight() * scale) / 2);

        stations = new ArrayList<>();

        Factory.createStations(1, 2.5f, screenWidth, screenHeight, stations);
    }

    public void update(float delta) {
        ship.update(delta);
        for (SpaceStations station : stations) {
            station.update(delta);

            if (
                station.isLoadItem() &&
                ship.getBounds().overlaps(station.getBounds()) &&
                    Gdx.input.isKeyJustPressed(Input.Keys.ENTER)
            ) {
                if (ship.getState() == ShipState.NO_LOAD) {
                    ship.setState(ShipState.WITH_LOAD);
                    ship.setPoints(ship.getPoints() + 1);
                    station.setLoadItem(false);
                }
                System.out.println("Status: " + ship.getState() + ", Pontos: " + ship.getPoints());
            }
        }
    }

    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();

        for (SpaceStations station : stations) {
            station.render(batch);
        }

        ship.render(batch);

        batch.end();
    }

    public void dispose() {
        batch.dispose();
        ship.dispose();

        for (SpaceStations station : stations) {
            station.dispose();
        }
    }
}
