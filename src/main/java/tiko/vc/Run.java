package tiko.vc;

import tiko.vc.battleship.Game;
import tiko.vc.battleship.gui.GUI;

/**
 * A CLass that starts the program.
 */
public class Run {

    /**
     * Starts the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
    	  //GUI gui = new GUI();
        Game.initializeGame();
    }
}