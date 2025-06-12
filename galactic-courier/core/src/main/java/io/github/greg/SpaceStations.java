package io.github.greg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

import java.util.List;

public class SpaceStations extends Base {
    private boolean isLoadItem = true;

    public SpaceStations() {
    }

    public SpaceStations(String imagePath, float x, float y, float scale, boolean isSpriteSheet) {
        super(imagePath, x, y, scale, isSpriteSheet);
    }

    public boolean isLoadItem() {
        return isLoadItem;
    }

    public void setLoadItem(boolean loadItem) {
        isLoadItem = loadItem;
    }
}
