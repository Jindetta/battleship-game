package tiko.vc.battleship;

import java.util.Optional;

/**
 * A class containing an individual cell data.
 */
public class Cell {

    /**
     * Define Ship object in this cell.
     */
    private Optional<Ship> shipData;

    /**
     * Define if cell was shot. Defaults to false.
     */
    private boolean shot;

    /**
     * Define if cell is visible. Defaults to true.
     */
    private boolean visible = true;

    /**
     *
     *
     * @return
     */
    public Optional<Ship> getShipData() {
        return shipData;
    }

    /**
     * Sets ship information.
     *
     * @param shipData Ship object.
     */
    public void setShipData(Ship shipData) {
        this.shipData = Optional.ofNullable(shipData);
    }

    /**
     *
     *
     * @return
     */
    public boolean isShot() {
        return shot;
    }

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