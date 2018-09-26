package battleship;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */
public class Game {

    /**
     *
     */
    public static final int ROWS = 10;

    /**
     *
     */
    public static final int COLUMNS = 10;

    /**
     *
     */
    public static final int MAP_SIZE = ROWS * COLUMNS;

    /**
     * Stores turn index.
     */
    private int turnIndex;

    /**
     * Stores player information.
     */
    private Player[] players;

    /**
     *
     */
    private String processInput() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            return input.readLine().toUpperCase();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     *
     */
    private Game() {
        
    }

    /**
     * Initializes a new game session.
     */
    public static void initializeGame() {
        Game game = new Game();


    }
}