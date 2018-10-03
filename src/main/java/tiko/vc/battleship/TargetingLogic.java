package tiko.vc.battleship;

import java.util.Random;
import static tiko.vc.battleship.Game.*;

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
}