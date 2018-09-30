package battleship;

/**
 * A class containing all necessary formatting for printing information.
 */
public class Helper {

    /**
     * Define length of total padding.
     */
    private static final int TOTAL_PADDING;

    /**
     * Define length of spacing between players.
     */
    private static final int PLAYER_SPACING;

    /**
     * Define length of column padding.
     */
    private static final int COLUMN_PADDING;

    /**
     * Define length of row padding.
     */
    private static final int ROW_PADDING;

    /**
     * Define constant for total.
     */
    public static final int IS_TOTAL = 0;

    /**
     * Define constant for spacing.
     */
    public static final int IS_SPACING = 1;

    /**
     * Define constant for column.
     */
    public static final int IS_COLUMN = 2;

    /**
     * Define constant for row.
     */
    public static final int IS_ROW = 3;

    /**
     * Define constant for row string.
     */
    public static final String ROW_STRING;

    /**
     * Define temporary static initializer to compile.
     */
    static {
        TOTAL_PADDING = 0;
        PLAYER_SPACING  = 0;
        COLUMN_PADDING = 0;
        ROW_PADDING = 0;
        ROW_STRING = "";
    }
}