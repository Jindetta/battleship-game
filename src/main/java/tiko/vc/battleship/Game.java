package battleship;

import java.util.Scanner;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;

/**
 * 
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
    public static final boolean DEBUG_MODE = true;

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
     *
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
     * Launches game menu.
     */
    public void launchMenu() {
        boolean exitMenu = false;
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();

        while (!exitMenu) {
            cp.println("******** BATTLESHIP - GAME ********", Attribute.NONE, FColor.BLUE, BColor.NONE);

            cp.print("1: ", Attribute.BOLD, FColor.WHITE, BColor.NONE);
            cp.println("Generate Ships (not implemented)", Attribute.NONE, FColor.GREEN, BColor.NONE);
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
                    case "2":
                    case "3":
                        cp.println("Sorry, not implemented!", Attribute.NONE, FColor.BLUE, BColor.NONE);
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
     *
     */
    private Game() {
        scanner = new Scanner(System.in, "UTF-8");
    }

    /**
     * Initializes a new game session.
     */
    public static void initializeGame() {
        Game game = new Game();
        game.launchMenu();
    }
}