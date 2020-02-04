package hu.polakosz.settlersj.iv.environment.generators;

import hu.polakosz.settlersj.iv.environment.EmptyTerrain;
import hu.polakosz.settlersj.iv.environment.Map;
import hu.polakosz.settlersj.iv.environment.Terrain;

import java.awt.Point;

public class EmptyTerrainGenerator extends TerrainGenerator {

    public EmptyTerrainGenerator(Map map) {
        super(map);
    }

    @Override
    public void generate() {
        EmptyTerrain lastTerrain = null;
        Point[] coordinates = super.map.getAllCoordinates();

        for (Point coordinate : coordinates) {
            EmptyTerrain newTerrain = new EmptyTerrain(coordinate);
            super.map.set(coordinate, newTerrain);

            if (lastTerrain != null) {
                newTerrain.previous = lastTerrain;
                lastTerrain.next = newTerrain;
            }

            lastTerrain = newTerrain;
        }
    }

    /**
     * Constructs a terrain type for a specific coordinate.
     *
     * @param coordinate The new terrain coordinate on the map.
     * @return Terrain instance depending on the generator.
     */
    @Override
    protected Terrain getTerrainType(Point coordinate) {
        return new EmptyTerrain(coordinate);
    }
}
