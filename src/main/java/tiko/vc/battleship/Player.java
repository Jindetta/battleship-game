package tiko.vc.battleship;

import java.util.Arrays;
import java.util.ArrayList;

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
     *
     *
     * @param index
     * @param direction
     * @param length
     *
     * @return
     */
    private ArrayList<Integer> getFreeAxis(int index, Directions direction, int length) {
        ArrayList<Integer> points = new ArrayList<>();
 
        switch (direction) {
            case DIRECTION_W:
                index -= length - 1;
            case DIRECTION_E:
 
                for (int x = index; x < (index + length); x++) {
                    if (hasCollision(x, index, true) || isOverlapping(x)) {
                        return null;
                    }
 
                    points.add(x);
                }
 
                break;
            case DIRECTION_N:
                index -= (length - 1) * COLUMNS;
            case DIRECTION_S:
                for (int x = index;
                     x < (index + (length * COLUMNS)); x += COLUMNS) {
 
                    if (hasCollision(x, index, false) || isOverlapping(x)) {
                        return null;
                    }
 
                    points.add(x);
                }
 
                break;
        }
 
        return points;
    }

    /**
     *
     *
     * @param index
     *
     * @return
     */
    private boolean isOverlapping(int index) {
        return false;
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