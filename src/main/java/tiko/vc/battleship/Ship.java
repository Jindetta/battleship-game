package battleship;

/**
 * 
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

    @Override
    public String toString() {
        return name != null ? name : "";
    }
}