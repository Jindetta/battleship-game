package battleship;

/**
 * A class that contains an individual ship data.
 */
public class Ship {

    /**
     * Define ship name.
     */
    private String name;

    /**
     * Define ship length.
     */
    private int length;

    /**
     *
     */
    public Ship() {
        
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }
}