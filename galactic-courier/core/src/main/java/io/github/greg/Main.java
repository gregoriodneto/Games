package io.github.greg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private GameScreen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameScreen();
    }

    @Override
    public void render() {
        gameScreen.update(Gdx.graphics.getDeltaTime());
        gameScreen.render();
    }

    @Override
    public void dispose() {
        gameScreen.dispose();
    }
}
