package tiko.vc.battleship;

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
     * Define constant for column string.
     */
    public static final String COLUMN_STRING;

    public static String formatString(int formatType, Object arg) {
        switch (formatType) {
            case IS_TOTAL:
                return String.format("%-" + TOTAL_PADDING + "s", arg);
            case IS_SPACING:
                return String.format("%" + PLAYER_SPACING + "s", arg);
            case IS_COLUMN:
                return String.format("%" + COLUMN_PADDING + "s", arg);
            case IS_ROW:
                return String.format("%-" + ROW_PADDING + "s", arg);
        }

        return String.format("%" + formatType + "s", arg);
    }

    /**
     * Define temporary static initializer to compile.
     */
    static {
        TOTAL_PADDING = 0;
        PLAYER_SPACING  = 0;
        COLUMN_PADDING = 0;
        ROW_PADDING = 0;
        ROW_STRING = "";
        COLUMN_STRING = "";
    }
}