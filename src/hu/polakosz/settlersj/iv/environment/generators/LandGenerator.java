package hu.polakosz.settlersj.iv.environment.generators;

import hu.polakosz.settlersj.iv.environment.Grass;
import hu.polakosz.settlersj.iv.environment.Map;
import hu.polakosz.settlersj.iv.environment.Terrain;

import java.awt.Point;

public class LandGenerator extends LimitedTerrainGenerator {

    public LandGenerator(Map map, int maxLandPercentage) {
        super(map, maxLandPercentage);
    }

    @Override
    protected void setOneTerrainCell() {
        discoverTerritory(super.map.getRandomCoordinate());
    }

    @Override
    protected Terrain getTerrainType(Point coordinate) {
        return new Grass(coordinate);
    }

    private void discoverTerritory(Point p) {
        expandLand(p);

        final int expandChance = 85;

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x, p.y - 1));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x + 1, p.y - 1));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x + 1, p.y));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x + 1, p.y + 1));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x, p.y + 1));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x - 1, p.y + 1));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x - 1, p.y));
        }

        if (random.nextInt(100) < expandChance) {
            expandLand(new Point(p.x - 1, p.y - 1));
        }
    }

    private void expandLand(Point p) {
        if (shouldBeLand(p)) {
            super.updateAt(p);
        }
    }

    private boolean shouldBeLand(Point p) {
        if (super.isCloseToEdge(p, 1)) {
            return false;
        }

        boolean shouldBeWater = 90 <= super.getEdgeDistancePercentage(p);
        if (shouldBeWater) {
            return false;
        }

        return true;
    }
}
