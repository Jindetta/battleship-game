package tiko.vc.battleship;

import java.util.Arrays;
import static tiko.vc.battleship.Game.*;

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
     * Gets player AI status.
     *
     * @return True when player is AI.
     */
    public boolean isAI() {
        return aiLogic != null;
    }

    /**
     * Checks if given index is within map bounds.
     *
     * @return True when within map bounds.
     */
    private boolean isInRange(int index) {
        return index >= 0 && index < map.length;
    }

    /**
     * Resets map data.
     */
    protected final void resetMap() {
        map = new Cell[MAP_SIZE];
 
        for (int i = 0; i < map.length; i++) {
            map[i] = new Cell(!isAI());
        }
    }

    /**
     * Overrides default constructor.
     *
     * @param humanPlayer Human player.
     * @param name        Player name.
     * @param vessels     Player vessels/fleet.
     */
    public Player(boolean humanPlayer, String name, Ship[] vessels) {
        // Short for: if (humanPlayer) aiLogic = null; else aiLogic = TargetingLogic;
        aiLogic = humanPlayer ? null : new TargetingLogic();

        setVessels(vessels);
        setName(name);

        resetMap();
    }
}