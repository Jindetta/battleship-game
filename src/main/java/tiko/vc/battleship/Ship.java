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

    /**
     * Gets ship name.
     *
     * @return Ship name as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets ship name.
     *
     * @param name Ship name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }
}