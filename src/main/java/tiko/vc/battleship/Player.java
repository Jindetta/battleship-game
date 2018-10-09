package tiko.vc.battleship;

import java.util.Arrays;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

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
     * Delegates shot current information to AI logic.
     *
     * @param index Shot index
     * @param value Shot type (miss, hit etc.)
     */
    protected void setShotLogic(int index, int value) {
        if (isAI()) {
            aiLogic.setShotData(index, value);
        }
    }

    /**
     * Gets AI logic data if available.
     *
     * @return index to the next target cell
     */
    protected int getShotLogic() {
        return isAI() ? aiLogic.nextShotIndex() : INVALID_VALUE;
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
     *
     *
     * @param index
     *
     * @return
     */
    private boolean isCellShot(int index) {
        return map[index % map.length].isShot();
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
     * Gets ship type.
     * 
     * @param type Ship type
     * 
     * @return Ship object if found
     */
    private Ship getShipByType(int type) {
        for (Ship ship : vessels) {
            if (ship.id == type) {
                return ship;
            }
        }
 
        return null;
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
    private Optional<ArrayList<Integer>> getFreeAxis(int index, Directions direction, int length) {
        ArrayList<Integer> indices = new ArrayList<>();
 
        switch (direction) {
            case DIRECTION_W:
                index -= length - 1;
            case DIRECTION_E:
                for (int x = index; x < (index + length); x++) {
                    if (hasCollision(x, index, true) || isOverlapping(x)) {
                        return Optional.empty();
                    }
 
                    indices.add(x);
                }
 
                break;
            case DIRECTION_N:
                index -= (length - 1) * COLUMNS;
            case DIRECTION_S:
                for (int x = index; x < (index + (length * COLUMNS)); x += COLUMNS) {
                    if (hasCollision(x, index, false) || isOverlapping(x)) {
                        return Optional.empty();
                    }
 
                    indices.add(x);
                }
 
                break;
        }
 
        return Optional.of(indices);
    }

    /**
     *
     *
     * @param currentIndex
     * @param startIndex
     * @param vertical
     *
     * @return
     */
    private boolean hasCollision(int currentIndex, int startIndex, boolean vertical) {
        if (isInRange(currentIndex)) {
            if ((!vertical && currentIndex % COLUMNS == startIndex % COLUMNS) || (vertical && currentIndex / COLUMNS == startIndex / COLUMNS)) {
                return map[currentIndex].getShipData().isPresent();
            }
        }
 
        return true;
    }

    /**
     *
     *
     * @param index
     *
     * @return
     */
    private boolean isOverlapping(int index) {
        if (!OVERLAPPING_ALLOWED) {
            final int[] NEIGHBOUR_CELLS = {
                index - COLUMNS, index + COLUMNS, index - 1, index + 1
            };

            AtomicInteger collisionSum = new AtomicInteger(0);

            for (int value : NEIGHBOUR_CELLS) {
                boolean isVertical = Math.abs(value - index) > 1;
                boolean notHorizontal = !isVertical && value % COLUMNS != index % COLUMNS;
                boolean notVertical = isVertical &&value / COLUMNS != index / COLUMNS;

                if (isInRange(value) && (notHorizontal || notVertical)) {
                    map[value].getShipData().ifPresent(s -> collisionSum.addAndGet(s.getLength()));
                }
            }

            return collisionSum.get() > 0;
        }

        return false;
    }

    /**
     *
     */
    private static <T extends Enum<?>> T randomEnum(Random rng, Class<T> e){
        int value = rng.nextInt(e.getEnumConstants().length);
        return e.getEnumConstants()[value];
    }

    /**
     *
     *
     * @param index
     * @param direction
     * @param ship
     *
     * @return
     */
    protected boolean placeShip(int index, Directions direction, Ship ship) { 
        Optional<ArrayList<Integer>> indices = getFreeAxis(index, direction, ship.getLength());
 
        indices.ifPresent(list -> list.stream().forEach(i -> map[i].setShipData(ship)));
        return indices.isPresent();
    }

    /**
     *
     */
    protected void generateShips() {
        Random rng = new Random();

        Directions direction;
        int index;

        for (int i = (vessels.length - 1); i >= 0; i--) {
            do {
                index = rng.nextInt(map.length);
                direction = randomEnum(rng, Directions.class);
            } while (!placeShip(index, direction, vessels[i]));
        }
    }

    /**
     *
     *
     * @param index
     *
     * @return
     */
    protected boolean shootTo(int index) {
        if (isInRange(index) && !isCellShot(index)) {
            map[index % map.length].setShot(true);

            return true;
        }
 
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