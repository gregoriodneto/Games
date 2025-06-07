package io.github.greg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Base {
    private SpriteBatch batch;
    private Texture image;
    protected float x;
    protected float y;
    protected float scale;

    public Base() {}

    public Base(String imagePath, float x, float y, float scale) {
        batch = new SpriteBatch();
        image = new Texture(imagePath);
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void update(float delta) {}

    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, x, y, image.getWidth() * scale, image.getHeight() * scale);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getScale() {
        return scale;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
