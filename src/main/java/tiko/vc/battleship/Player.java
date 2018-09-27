package battleship;

/**
 * 
 */
public class Player {

    /**
     * Stores player name.
     */
    private String name;

    /**
     * Stores player map data.
     */
    private Cell[] map;

    /**
     * Stores player ship data.
     */
    private Ship[] vessels;

    /**
     * Gets player name.
     *
     * @return Player name as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets player name.
     *
     * @param name Player name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public Player() {
        
    }
}