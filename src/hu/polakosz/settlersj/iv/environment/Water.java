package hu.polakosz.settlersj.iv.environment;

import hu.polakosz.settlersj.iv.environment.views.WaterView;

import java.awt.Point;

public class Water extends Terrain {

    public Water(Point coordinate) {
        super(new WaterView(coordinate));
    }
}
