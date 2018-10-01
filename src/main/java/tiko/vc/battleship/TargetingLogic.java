package battleship;

import java.util.Random;
import static battleship.Game.*;

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
    }

    /**
     * Generates random number between 0 - 9.
     *
     * @return int number.
     */
    public int random() {
        return rng.nextInt(0, 10);
    }
}