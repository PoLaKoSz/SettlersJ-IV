package hu.polakosz.settlersj.iv.environment.generators;

import hu.polakosz.settlersj.iv.environment.Map;
import hu.polakosz.settlersj.iv.environment.Terrain;

import java.awt.Point;
import java.util.Random;

public abstract class TerrainGenerator {
    protected static final Random random = new Random();
    protected final Map map;

    public TerrainGenerator(Map map) {
        this.map = map;
    }

    /**
     * Populate the terrain 2D array with the appropriate terrain.
     */
    public abstract void generate();

    /**
     * Constructs a terrain type for a specific coordinate.
     * @param coordinate The new terrain coordinate on the map.
     * @return Terrain instance depending on the generator.
     */
    protected abstract Terrain getTerrainType(Point coordinate);

    /**
     * Replace the terrain at a given coordinate with generator type.
     * @param coordinate Coordinate for the new terrain.
     * @throws IllegalArgumentException Occurs when the coordinate
     * is outside of the map.
     */
    protected void updateAt(Point coordinate) {
        this.map.set(coordinate, getTerrainType(coordinate));
    }

    protected double getEdgeDistancePercentage(Point p) {
        int topDistance = p.y;
        int bottomDistance = this.map.height - p.y - 1;

        int leftDistance = p.x;
        int rightDistance = this.map.width - p.x - 1;

        int verticalDistance = Math.min(topDistance, bottomDistance);
        int horizontalDistance = Math.min(leftDistance, rightDistance);

        double verticalPercentage = 100 - verticalDistance * 100.0 / this.map.height;
        double horizontalPercentage = 100 - horizontalDistance * 100.0 / this.map.width;

        double result = (verticalPercentage + horizontalPercentage) / 2;

        return result;
    }

    protected boolean isCloseToEdge(Point p, int distance) {
        int topDistance = p.y;
        if (topDistance < distance) {
            return true;
        }

        int bottomDistance = this.map.height - p.y - 1;
        if (bottomDistance < distance) {
            return true;
        }

        int leftDistance = p.x;
        if (leftDistance < distance) {
            return true;
        }

        int rightDistance = this.map.width - p.x - 1;
        if (rightDistance < distance) {
            return true;
        }

        return false;
    }
}
