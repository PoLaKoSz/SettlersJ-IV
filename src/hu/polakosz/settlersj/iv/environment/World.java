package hu.polakosz.settlersj.iv.environment;

import com.codecool.termlib.Terminal;
import hu.polakosz.settlersj.iv.environment.generators.EmptyTerrainGenerator;
import hu.polakosz.settlersj.iv.environment.generators.LandGenerator;

import java.awt.Point;

public class World {

    private final Map map;
    private final int maxLandPercentage;

    public World(Map map, int maxLandPercentage) {
        this.map = map;
        this.maxLandPercentage = maxLandPercentage;
    }

    public void generate() {
        initializeWithEmptyTerrain();
        generateLand();
    }

    public void draw() {
        Terminal terminal = new Terminal();
        terminal.clearScreen();

        for (int y = 0; y < this.map.height; y++) {
            for (int x = 0; x < this.map.width; x++) {
                this.map.getTerrainAt(new Point(x, y)).view.draw();
            }
            terminal.setChar('\n');
        }
    }

    private void initializeWithEmptyTerrain() {
        EmptyTerrainGenerator generator = new EmptyTerrainGenerator(this.map);
        generator.generate();
    }

    private void generateLand() {
        LandGenerator generator = new LandGenerator(this.map, this.maxLandPercentage);
        generator.generate();
    }
}
