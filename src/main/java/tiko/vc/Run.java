package tiko.vc;

import tiko.vc.battleship.GUI;
import tiko.vc.battleship.Game;

/**
 * 
 */
public class Run {

    /**
     * Starts the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
    	GUI gui = new GUI();
    	
        Game.initializeGame();
    }
}