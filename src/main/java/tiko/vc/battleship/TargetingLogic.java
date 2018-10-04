package tiko.vc.battleship;

import java.util.Random;
import static tiko.vc.battleship.Game.*;
import java.util.Arraylist;

/**
 * A class that handles the targeting of shots.
 */
public class TargetingLogic {
	
    /**
     * Define random number generator.
     */
    private Random rng;

	/**
	 * Contains the information of the game map positions, and priorites the positions.
	 */
	private int[] priorityMap;

    /**
     * Define a priority for ignored cells.
     */
    private final static int IGNORE_PRIORITY = 0;

    /**
     *
     */
    public TargetingLogic() {
        rng = new Random();

        priorityMap = new int[MAP_SIZE];
        int currentRow = rng.nextInt(2) + 1;

        for (int i = 0; i < priorityMap.length; i++) {
            int p = (i + 1) % 2;
            priorityMap[i] = currentRow % 2 == 0 ? 1 + p : 2 - p;
 
            if (COLUMNS % 2 == 0 && (i + 1) % COLUMNS == 0) {
                currentRow++;
            }
        }
    }

    /**
     * Gets highest available priority from the map.
     * 
     * @return value with highest priority
     */
    private int getHighestPriorityValue() {
        int highestValue = IGNORE_PRIORITY;

        for (int priority : priorityMap) {
            if (priority > highestValue) {
                highestValue = priority;
            }
        }

        return highestValue;
    }

    /**
     * Gets list of cells with highest priority.
     *
     * @return a list of cells
     */
    private ArrayList<Integer> getPriorityList() {
        int highestPriority = getHighestPriorityValue();
        ArrayList<Integer> priorities = new ArrayList<>();
 
        for (int i = 0; i < priorityMap.length; i++) {
            if (priorityMap[i] == highestPriority) {
                priorities.add(i);
            }
        }
 
        return priorities;
    }
}