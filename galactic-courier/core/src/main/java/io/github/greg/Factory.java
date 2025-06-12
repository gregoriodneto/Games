package io.github.greg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

import java.util.List;

public class Factory {
    public static void createStations(
        int quantity,
        float scale,
        float screenWidth,
        float screenHeight,
        List<SpaceStations> stations
    ) {
        for (int i = 0; i < quantity; i++) {
            float stationWidth = new Texture("icon_teleporter.png").getWidth() * scale;
            float stationHeight = new Texture("icon_teleporter.png").getHeight() * scale;

            float x = MathUtils.random(0, screenWidth - stationWidth);
            float y = MathUtils.random(0, screenHeight - stationHeight);

            stations.add(new SpaceStations("icon_teleporter.png", x, y, scale, false));
        }
    }
}
