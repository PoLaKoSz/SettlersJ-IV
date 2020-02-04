package hu.polakosz.settlersj.iv.environment.generators;

import hu.polakosz.settlersj.iv.environment.Map;

import java.awt.Point;

public abstract class LimitedTerrainGenerator extends TerrainGenerator {
    private final int maxTerrainCount;
    private int terrainCellCount;

    public LimitedTerrainGenerator(Map map, int maxTerrainPercentage) {
        super(map);
        this.maxTerrainCount = calculateMaxTerrainCount(maxTerrainPercentage);
    }

    /**
     * Populate the terrain 2D array with the appropriate terrain.
     */
    @Override
    public void generate() {
        while (this.terrainCellCount < this.maxTerrainCount)
        {
            setOneTerrainCell();
        }
    }

    protected abstract void setOneTerrainCell();

    /**
     * Replace the terrain at a given coordinate with generator type.
     * @param coordinate Coordinate for the new terrain.
     * @exception UnsupportedOperationException Occurs
     * when the new terrain will reach the maximum count.
     */
    protected void updateAt(Point coordinate) {
        if (this.maxTerrainCount < this.terrainCellCount) {
            return;
            /*
            throw new UnsupportedOperationException(
                    String.format("Cannot replace terrain at %s because it would exceed the maximum (%d) count!",
                            coordinate, this.maxTerrainCount));
            */
        }

        super.updateAt(coordinate);
        this.terrainCellCount++;
    }

    private int calculateMaxTerrainCount(int maxTerrainPercentage) {
        return ((super.map.width * super.map.height) * maxTerrainPercentage) / 100;
    }
}
