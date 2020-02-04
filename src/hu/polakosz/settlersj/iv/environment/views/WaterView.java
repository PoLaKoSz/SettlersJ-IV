package hu.polakosz.settlersj.iv.environment.views;

import com.codecool.termlib.RGB;

import java.awt.Point;

public class WaterView extends View {
    public WaterView(Point coordinate) {
        super(coordinate);
    }

    @Override
    public void draw() {
        RGB fontColor = new RGB(204, 238, 255);
        RGB backgroundColor = new RGB(0, 85, 128);
        super.draw('≈', fontColor, backgroundColor);
    }
}
