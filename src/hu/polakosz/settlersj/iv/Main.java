package hu.polakosz.settlersj.iv;

import hu.polakosz.settlersj.iv.environment.Map;
import hu.polakosz.settlersj.iv.environment.World;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(150, 30);
        World world = new World(map, 80);
        world.generate();
        world.draw();
    }
}
