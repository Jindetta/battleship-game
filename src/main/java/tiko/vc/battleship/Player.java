package battleship;

import java.util.Arrays;

/**
 * A class containing the data needed for the player.
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
     * Stores AI targeting logic.
     */
    private TargetingLogic aiLogic;

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
     * Sets player vessels.
     */
    public void setVessels(Ship[] vessels) {
        this.vessels = Arrays.copyOf(vessels, vessels.length);
    }

    /**
     * Overrides default constructor.
     *
     * @param humanPlayer Human player.
     * @param name        Player name.
     * @param vessels     Player vessels/fleet.
     */
    public Player(boolean humanPlayer, String name, Ship[] vessels) {

    }
}