package battleship;

/**
 * A class containing an individual cell data.
 */
public class Cell {

    /**
     * Define ship type in this cell. Defaults to none.
     */
    public int type = 0;

    /**
     * Define if cell was shot. Defaults to false.
     */
    public boolean shot = false;

    /**
     * Define if cell is visible. Defaults to true.
     */
    private boolean visible = true;

    /**
     *
     */
    public Cell() {
        
    }

    /**
     * Sets cell visible.
     */
    protected void setVisible() {
        visible = true;
    }

    public String toString() {
    }
}