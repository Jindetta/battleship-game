package battleship;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */
public class Game {

    /**
     * Defines the amount of rows of the game.
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
     * Prompts for user input.
     *
     * @return Trimmed user input as String (uppercase).
     */
    private String getUserInput() {
        String output;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            output = input.readLine().toUpperCase();
        } catch (Exception e) {
            output = e.getMessage();
        }

        return output.trim();
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