package hu.polakosz.settlersj.iv.environment.views;

import com.codecool.termlib.RGB;

import java.awt.Point;

public class EmptyView extends View {

    public EmptyView(Point coordinate) {
        super(coordinate);
    }

    @Override
    public void draw() {
        RGB fontColor = new RGB(255, 255, 255);
        RGB backgroundColor = new RGB(0, 0, 0);
        super.draw('☠', fontColor, backgroundColor);
    }
}
