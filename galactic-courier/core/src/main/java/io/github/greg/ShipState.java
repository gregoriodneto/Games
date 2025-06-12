package io.github.greg;

public enum ShipState {
    WITH_LOAD("WITH_LOAD"),
    NO_LOAD("NO_LOAD"),
    DELIVERED("DELIVERED"),
    COLLIDED("COLLIDED");

    private final String status;

    ShipState(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
