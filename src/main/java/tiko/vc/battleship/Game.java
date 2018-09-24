package battleship;

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
    public Game() {
        
    }
}