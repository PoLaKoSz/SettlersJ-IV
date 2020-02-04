package hu.polakosz.settlersj.iv.environment.generators;

import hu.polakosz.settlersj.iv.environment.*;

import javax.naming.OperationNotSupportedException;
import java.awt.Point;

public class OceanGenerator extends TerrainGenerator {

    public OceanGenerator(Map map) {
        super(map);
    }

    /**
     * Populate the terrain 2D array with the appropriate terrain.
     */
    @Override
    public void generate() {
        Point[] coordinates = super.map.getAllCoordinates();
        EmptyTerrain firstTerrain = null;

        for (Point coordinate : coordinates) {
            Terrain foundTerrain = super.map.getTerrainAt(coordinate);
            if (foundTerrain instanceof EmptyTerrain) {
                firstTerrain = (EmptyTerrain) foundTerrain;
                break;
            }
        }

        if (firstTerrain == null) {
            return;
        }

        while (firstTerrain != null) {
            Point coordinate = firstTerrain.view.coordinate;
            firstTerrain = firstTerrain.next;
            super.updateAt(coordinate);
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
        return new Water(coordinate);
    }
}
