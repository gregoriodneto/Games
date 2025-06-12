package io.github.greg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Base {
    private Texture image;
    private TextureRegion[] sprites;
    protected float x;
    protected float y;
    protected float scale;
    protected boolean isSpriteSheet;

    public Base() {}

    public Base(String imagePath, float x, float y, float scale, boolean isSpriteSheet) {
        image = new Texture(imagePath);
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.isSpriteSheet = isSpriteSheet;
    }

    public void update(float delta) {}

    public void render(SpriteBatch batch) {
        if (isSpriteSheet) {
            batch.draw(sprites[0], x, y, image.getWidth() * scale, image.getHeight() * scale);
        } else {
            batch.draw(image, x, y, image.getWidth() * scale, image.getHeight() * scale);
        }
    }

    public void spriteSheetRender(int frameCols, int frameRows) {
        TextureRegion[][] tmp = TextureRegion.split(
            image,
            image.getWidth() / frameCols,
            image.getHeight() / frameRows
        );

        sprites = new TextureRegion[frameCols * frameRows];
        int index = 0;
        for (int i = 0; i < frameRows; i++) {
            for (int j = 0; j < frameCols; j++) {
                sprites[index++] = tmp[i][j];
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getWidth() * scale, getHeight() * scale);
    }

    public void dispose() {
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

    public float getWidth() {
        return image.getWidth();
    }

    public float getHeight() {
        return image.getHeight();
    }

    public boolean isSpriteSheet() { return isSpriteSheet; }

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
