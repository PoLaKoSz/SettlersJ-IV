package hu.polakosz.settlersj.iv.environment;

import hu.polakosz.settlersj.iv.environment.views.GrassView;

import java.awt.Point;

public class Grass extends Terrain {

    public Grass(Point coordinate) {
        super(new GrassView(coordinate));
    }
}
