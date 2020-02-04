package hu.polakosz.settlersj.iv.environment;

import hu.polakosz.settlersj.iv.environment.views.View;

import java.security.InvalidParameterException;

public abstract class Terrain {
    public final View view;

    public Terrain(View view) {
        this.view = view;
    }

    /**
     * Replace this terrain type with a new one (on the same
     * coordinate).
     * @param terrain
     * @exception InvalidParameterException Occurs when the
     * current terrain can't be replaced with the new one.
     */
    public void doReplaceWith(Terrain terrain) {
        if (!this.canBeReplacedWith(terrain)) {
            return;
        }

        this.replaceWith(terrain);
    }

    /**
     * Checks if the current terrain could be replaced with
     * the parameter one.
     *
     * @param terrain Desired terrain.
     * @return true if the replace could be done, false otherwise.
     */
    public boolean canBeReplacedWith(Terrain terrain) {
        return false;
    }

    /**
     * Replace this instance with a new terrain type.
     *
     * @param terrain Desired terrain.
     * @throws UnsupportedOperationException Occurs when this method doesn't get overridden.
     */
    protected void replaceWith(Terrain terrain) {
        throw new UnsupportedOperationException(String.format("%s doesn't override replaceWith() method!",
                getClass().getName()));
    }
}
