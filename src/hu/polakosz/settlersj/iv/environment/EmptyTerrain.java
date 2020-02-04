package hu.polakosz.settlersj.iv.environment;

import hu.polakosz.settlersj.iv.environment.views.EmptyView;

import java.awt.Point;

public class EmptyTerrain extends Terrain {
    public EmptyTerrain previous;
    public EmptyTerrain next;

    public EmptyTerrain(Point coordinate) {
        super(new EmptyView(coordinate));
    }

    /**
     * Checks if the current terrain could be replaced with
     * the parameter one.
     *
     * @param terrain Desired terrain.
     * @return true if the replace could be done, false otherwise.
     */
    @Override
    public boolean canBeReplacedWith(Terrain terrain) {
        if (terrain == null) {
            return false;
        }

        if (terrain instanceof EmptyTerrain) {
            return false;
        }

        return true;
    }

    /**
     * Replace this instance with a new terrain type.
     *
     * @param terrain Desired terrain.
     */
    @Override
    protected void replaceWith(Terrain terrain) {
        if (this.previous != null && this.next != null) {
            this.previous.next = this.next;
            this.next.previous = this.previous;
        } else if (this.previous != null) {
            this.previous.next = null;
        } else if (this.next != null) {
            this.next.previous = null;
        }
    }
}
