package tiko.vc.battleship;

import java.util.Scanner;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;

import static tiko.vc.battleship.Helper.*;

/**
 * A class that creates the game and combines all needed classes.
 */
public class Game {

    /**
     * Defines the amount of rows of the game.
     */
    public static final int ROWS = 10;

    /**
     * Defines the amount of columns of the game.
     */
    public static final int COLUMNS = 10;

    /**
     * Calculates the size of the game map by using constants ROWS and COLUMNS.
     */
    public static final int MAP_SIZE = ROWS * COLUMNS;

    /**
     * Defines debug mode status.
     */
    public static final boolean DEBUG_MODE = false;

    /**
     * Defines if overlapping is allowed.
     */
    public static final boolean OVERLAPPING_ALLOWED = false;

    /**
     * Define invalid index constant.
     */
    public static final int INVALID_VALUE = -1;

    /**
     * Stores turn index.
     */
    private int turnIndex;

    /**
     * Stores player information.
     */
    private Player[] players;
    
    /**
     * Define ship types in constant array.
     */
    public final Ship[] SHIPS = {
    	new Ship(2, 'd', "Destroyer"),
    	new Ship(3, 's', "Submarine"),
    	new Ship(3, 'c', "Cruiser"),
    	new Ship(4, 'b', "Battleship"),
    	new Ship(5, 'C', "Carrier")
    };

    /**
     * Scanner to read users input.
     */
    private Scanner scanner;

    /**
     * Prompts for user input.
     *
     * @return Trimmed user input as String (uppercase).
     */
    private String getUserInput() {
        String output = scanner.nextLine();
        return output.trim().toUpperCase();
    }

    /**
     *
     *
     * @param targetingData
     * @return
     */
    private int processMove(String targetingData) {
        if (targetingData != null && targetingData.length() >= 2) {
            return coordToIndex(targetingData);
        }
 
        return INVALID_VALUE;
    }

    /**
     * Converts coordinate String to cell index.
     * 
     * @param coords String value.
     *
     * @return Cell index as Integer.
     */
    private int coordToIndex(String coords) {
        try {
            int letter = ROW_STRING.indexOf(coords.charAt(0));
            int number = Integer.parseInt(coords.substring(1)) - 1;
 
            if (number < 0 || number >= COLUMNS || letter >= ROWS) {
                throw new IllegalArgumentException();
            }
 
            return letter * COLUMNS + number;
        } catch (Exception e) {
            return INVALID_VALUE;
        }
    }

    /**
     *
     *
     * @return
     */
    public boolean move() {
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();
        Player current = players[turnIndex % players.length];
        Player opponent = players[(turnIndex + 1) % players.length];
        boolean valid = false;
 
        while (!valid) {
            if (current.isAI()) {
                int index = current.getShotLogic();
 
                if (valid = opponent.shootTo(index)) {
                    int value = opponent.getShotInformation(index);
                    current.setShotLogic(index, value);
 
                    cp.print(current + ":", Attribute.BOLD, FColor.RED, BColor.NONE);

                    if (value > 0) {
                        cp.println("Hit confirmed!", Attribute.NONE, FColor.NONE, BColor.NONE);
                    } else if (value < 0) {
                        cp.println(opponent.getShipName(value) + " sank!", Attribute.NONE, FColor.NONE, BColor.NONE);
                    } else {
                        cp.println("Shot missed!", Attribute.NONE, FColor.NONE, BColor.NONE);
                    }
 
                    //current.stats.increaseShotsFired(value != 0);
                }
            } else {
                cp.print("Enter coordinates or type 'exit': ", Attribute.BOLD, FColor.NONE, BColor.NONE);
                String query = getUserInput();
 
                if (query.equals("EXIT")) {
                    cp.clear();
                    return false;
                }
 
                int index = processMove(query);
 
                if (index != INVALID_VALUE) {
                    if (valid = opponent.shootTo(index)) {
                        int value = opponent.getShotInformation(index);
 
                        cp.print(current + ":", Attribute.BOLD, FColor.BLUE, BColor.NONE);

                        if (value > 0) {
                            cp.println("Hit confirmed!", Attribute.NONE, FColor.NONE, BColor.NONE);
                        } else if (value < 0) {
                            cp.println(opponent.getShipName(value) + " sank!", Attribute.NONE, FColor.NONE, BColor.NONE);
                        } else {
                            cp.println("Shot missed!", Attribute.NONE, FColor.NONE, BColor.NONE);
                        }
 
                        //current.stats.increaseShotsFired(value != 0);
                    } else {
                        cp.println("Choose coordinates you haven't targeted before.", Attribute.BOLD, FColor.RED, BColor.NONE);
                    }
                } else {
                    cp.println("Coordinates were invalid!", Attribute.BOLD, FColor.RED, BColor.NONE);
                }
            }
        }

        cp.clear();
        return true;
    }

    /**
     *
     *
     * @return
     */
    public Player playRound() {
        boolean gameRunning = true;
        Player winningPlayer = null;
 
        while (gameRunning && winningPlayer == null) {
            Player currentPlayer = currentPlayerTurn();
 
            if (currentPlayer.shipsDestroyed()) {
                winningPlayer = nextPlayerTurn();
 
                for (Player player : players) {
                    //player.stats.increaseGamesPlayed(player == winningPlayer);
                    player.setCellsVisible();  
                }
 
                printMap(null);
            } else {
                if (!currentPlayer.isAI()) {
                    printMap(null);
                }
 
                gameRunning = move();
                nextPlayerTurn();
            }
        }
 
        return winningPlayer;
    }

    /**
     * Launches game menu.
     */
    public void launchMenu() {
        boolean exitMenu = false;
        boolean initialSetupCompleted = false;
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();

        while (!exitMenu) {
            cp.println("******** BATTLESHIP - GAME ********", Attribute.NONE, FColor.BLUE, BColor.NONE);

            cp.print("1: ", Attribute.BOLD, FColor.WHITE, BColor.NONE);
            cp.println("Generate Ships", Attribute.NONE, FColor.GREEN, BColor.NONE);
            cp.print("2: ", Attribute.BOLD, FColor.WHITE, BColor.NONE);
            cp.println("Place Ships (not implemented)", Attribute.NONE, FColor.GREEN, BColor.NONE);
            cp.print("3: ", Attribute.BOLD, FColor.WHITE, BColor.NONE);
            cp.println("Start Game (not implemented)", Attribute.NONE, FColor.GREEN, BColor.NONE);
            cp.print("4: ", Attribute.BOLD, FColor.WHITE, BColor.NONE);
            cp.println("Exit Game", Attribute.NONE, FColor.GREEN, BColor.NONE);

            try {
                cp.println("", Attribute.BOLD, FColor.WHITE, BColor.NONE);
                System.out.print("Enter selection: ");

                switch (getUserInput()) {
                    case "1":
                        generateShips();
                        cp.println("Ships were placed randomly.", Attribute.NONE, FColor.BLUE, BColor.NONE);
                        initialSetupCompleted = true;
                        break;
                    case "2":
                        cp.println("Sorry, not implemented!", Attribute.NONE, FColor.BLUE, BColor.NONE);
                        break;
                    case "3":
                        if (initialSetupCompleted) {
                            Player winner = playRound();
                            cp.println(winner.toString() + " won the game!", Attribute.BOLD, FColor.GREEN, BColor.NONE);
                            initialSetupCompleted = false;
                        } else {
                            throw new Exception("You need to generate ships first.");
                        }
                        break;
                    case "4":
                        exitMenu = true;
                        cp.println("Thank you for playing!", Attribute.NONE, FColor.GREEN, BColor.NONE);
                        break;
                    default:
                        throw new Exception("Unknown selection.");
                }
            } catch (Exception e) {
                cp.println(e.getMessage(), Attribute.BOLD, FColor.RED, BColor.NONE);
            }

            cp.println("");
        }

        cp.clear();
    }

    /**
     * Gets current player in turn.
     *
     * @return Player object.
     */
    private Player currentPlayerTurn() {
        return players[turnIndex % players.length];
    }

    /**
     * Gets next player in turn.
     *
     * @return Player object.
     */
    private Player nextPlayerTurn() {
        return players[++turnIndex % players.length];
    }

    /**
     * Sets next turn by random.
     */
    private void setRandomPlayerTurn() {
        turnIndex = (int) (Math.random() * players.length);
    }

    /**
     * Places ships manually.
     * 
     * @return true if ships were successfully placed, otherwise false
     */
    private boolean placeShips() {
        return false;
    }

    /**
     * Generates ships for all players.
     */
    public void generateShips() {
        for (Player player : players) {
            player.resetMap();
            player.generateShips();
 
            if (!player.isAI()) {
                printMap(player);
            }
        }
    }

    /**
     *
     * 
     * @param player
     */
    public void printMap(Player player) {
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();

        if (player != null) {
            String[] output = renderMap(player);
 
            cp.println(COLUMN_STRING, Attribute.BOLD, FColor.BLUE, BColor.NONE);
 
            for (int x = 0; x < output.length; x++) {
                String prefix = formatString(IS_ROW, ROW_STRING.charAt(x));
                cp.print(prefix, Attribute.BOLD, FColor.BLUE, BColor.NONE);
                cp.println(output[x], Attribute.NONE, FColor.NONE, BColor.NONE);
            }
        } else {
            String[][] output = new String[players.length][];
            String suffix = formatString(IS_SPACING, "");
 
            for (int i = 0; i < output.length; i++) {
                output[i] = renderMap(players[i]);

                if (i == 0) {
                    cp.print(formatString(IS_TOTAL, players[i]) + suffix, Attribute.BOLD, FColor.WHITE, BColor.BLUE);
                } else {
                    cp.print(formatString(IS_TOTAL, players[i]) + suffix, Attribute.BOLD, FColor.WHITE, BColor.RED);
                }
            }

            cp.println("", Attribute.NONE, FColor.NONE, BColor.NONE);
 
            for (int i = 0; i < output.length; i++) {
                if (i == 0) {
                    cp.print(COLUMN_STRING, Attribute.BOLD, FColor.BLUE, BColor.NONE);
                } else {
                    cp.print(COLUMN_STRING, Attribute.BOLD, FColor.RED, BColor.NONE);
                }
            }

            cp.println("", Attribute.NONE, FColor.NONE, BColor.NONE);
 
            for (int i = 0; i < ROWS; i++) {
                String prefix = formatString(IS_ROW, ROW_STRING.charAt(i));
 
                for (String[] line : output) {
                    if (i == 0) {
                        cp.print(prefix, Attribute.BOLD, FColor.BLUE, BColor.NONE);
                    } else {
                        cp.print(prefix, Attribute.BOLD, FColor.RED, BColor.NONE);
                    }

                    cp.print(line[i] + suffix, Attribute.NONE, FColor.NONE, BColor.NONE);
                }
 
                cp.println("");
            }
        }
 
        cp.clear();
        print();
    }

    /**
     * Overrides default constructor.
     */
    private Game() {
        scanner = new Scanner(System.in, "UTF-8");

        players = new Player[] {
            new Player(true, "YOU", SHIPS),
            new Player(false, "AI", SHIPS)
        };
    }

    /**
     * Initializes a new game session.
     */
    public static void initializeGame() {
        Game game = new Game();
        game.launchMenu();
    }
}