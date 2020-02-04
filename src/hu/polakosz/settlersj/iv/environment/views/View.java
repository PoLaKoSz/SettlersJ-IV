package hu.polakosz.settlersj.iv.environment.views;

import com.codecool.termlib.RGB;
import com.codecool.termlib.Terminal;

import java.awt.Point;

public abstract class View {
    public final Point coordinate;
    private Terminal output;

    public View(Point coordinate) {
        this.coordinate = coordinate;
        this.output = new Terminal();
    }

    public abstract void draw();

    protected void draw(char symbol, RGB fontColor, RGB backgroundColor) {
        this.output.moveTo(this.coordinate.x + 1, this.coordinate.y + 1);
        this.output.set(symbol, fontColor, backgroundColor);
    }
}
