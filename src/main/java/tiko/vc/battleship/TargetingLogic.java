package tiko.vc.battleship;

import java.util.random;

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
}