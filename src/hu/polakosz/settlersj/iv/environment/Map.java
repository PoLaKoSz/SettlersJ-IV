package hu.polakosz.settlersj.iv.environment;

import java.awt.Point;
import java.util.Random;

public class Map {
    public final int width;
    public final int height;
    protected static final Random random = new Random();
    private final Terrain[][] terrain;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.terrain = new Terrain[this.height][this.width];
    }

    /**
     * Gets a valid coordinate from the map.
     * @return Non null instance.
     */
    public Point getRandomCoordinate() {
        return new Point(random.nextInt(this.width), random.nextInt(this.height));
    }

    /**
     * Gets the terrain at a given coordinate..
     * @param coordinate
     * @throws IllegalArgumentException Occurs when the coordinate
     * is outside of the map.
     */
    public Terrain getTerrainAt(Point coordinate) {
        if (this.isOutsideOfWorld(coordinate)) {
            throw new IllegalArgumentException(String.format("%s is outside of the map!", coordinate));
        }

        return this.terrain[coordinate.y][coordinate.x];
    }

    public Point[] getAllCoordinates() {
        Point[] coordinates = new Point[this.width * this.height];

        int i = 0;
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                coordinates[i] = new Point(x, y);
                i++;
            }
        }

        return coordinates;
    }

    public boolean isOutsideOfWorld(Point p) {
        if (p.x < 0) {
            return true;
        }

        if (this.width <= p.x) {
            return true;
        }

        if (p.y < 0) {
            return true;
        }

        if (this.height <= p.y) {
            return true;
        }

        return false;
    }

    /**
     * Sets the terrain at a given coordinate..
     * @param coordinate
     * @throws IllegalArgumentException Occurs when the coordinate
     * is outside of the map.
     */
    public void set(Point coordinate, Terrain terrain) {
        if (this.isOutsideOfWorld(coordinate)) {
            throw new IllegalArgumentException(String.format("%s is outside of the map!", coordinate));
        }

        if (this.terrain[coordinate.y][coordinate.x] != null) {
            this.terrain[coordinate.y][coordinate.x].doReplaceWith(terrain);
        }

        this.terrain[coordinate.y][coordinate.x] = terrain;
    }
}
