package tiko.vc.battleship;

import java.util.Random;
import static battleship.Game.*;

/**
 * 
 */
public class TargetingLogic {
	
    /**
     *
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

    public int random() {
        return rng.nextInt(0, 10);
    }
}