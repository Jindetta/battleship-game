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
     * Sets cell state as shot.
     *
     * @param shot Cell shot state.
     */
    public void setShot(boolean shot) {
        this.shot = shot;
    }

    /**
     * Override constructor.
     *
     * @param visible Cell visibility
     */
    public Cell(boolean visible) {
        this.visible = visible;

        setShipData(null);
        setShot(false);
    }

    /**
     * Sets cell visible.
     */
    protected void setVisible() {
        visible = true;
    }

    /**
     * Gets cell visible state.
     *
     * @return Cell visible state.
     */
    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        char value = '-';

        if (shipData.isPresent()) {
            if (shot) {
                value = 'X';
            } else {
                if (visible) {
                    value = '@';
                }

                if (Game.DEBUG_MODE) {
                    value = (char) shipData.get().getId();
                }
            }
        } else if (shot) {
            value = 'o';
        }

        return String.valueOf(value);
    }
}