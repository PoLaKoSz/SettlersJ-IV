package hu.polakosz.settlersj.iv.environment.views;

import com.codecool.termlib.RGB;

import java.awt.Point;

public class GrassView extends View {
    public GrassView(Point coordinate) {
        super(coordinate);
    }

    @Override
    public void draw() {
        RGB fontColor = new RGB(102, 255, 102);
        RGB backgroundColor = new RGB(0, 153, 0);
        super.draw('░', fontColor, backgroundColor);
    }
}
