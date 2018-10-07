package tiko.vc.battleship;

import java.util.Optional;

/**
 * A class containing an individual cell data.
 */
public class Cell {

    /**
     * Define Ship object in this cell.
     */
    private Ship data;

    /**
     * Define if cell was shot. Defaults to false.
     */
    public boolean shot = false;

    /**
     * Define if cell is visible. Defaults to true.
     */
    private boolean visible = true;

    /**
     * Override constructor.
     *
     * @param visible Cell visibility
     */
    public Cell(boolean visible) {
        this.visible = visible;
    }

    /**
     * Sets cell visible.
     */
    protected void setVisible() {
        visible = true;
    }

    @Override
    public String toString() {
        char value = '-';

        if (type != 0) {
            if (shot) {
                value = 'X';
            } else {
                if (visible) {
                    value = '@';
                }

                if (Game.DEBUG_MODE) {
                    value = (char) type;
                }
            }
        } else if (shot) {
            value = 'o';
        }

        return String.valueOf(value);
    }
}