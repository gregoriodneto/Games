package io.github.greg;

public class SpaceStations extends Base {
    private boolean isLoadItem = true;

    public SpaceStations() {
    }

    public SpaceStations(String imagePath, float x, float y, float scale) {
        super(imagePath, x, y, scale);
    }

    public boolean isLoadItem() {
        return isLoadItem;
    }

    public void setLoadItem(boolean loadItem) {
        isLoadItem = loadItem;
    }
}
