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

    /**
     * Gets total padding amount.
     *
     * @return Total padding value.
     */
    public static int getTotalPadding() {
        return TOTAL_PADDING;
    }

    /**
     * Gets player spacing amount.
     *
     * @return Player spacing value.
     */
    public static int getPlayerSpacing() {
        return PLAYER_SPACING;
    }

    /**
     * Gets column padding amount.
     *
     * @return Column padding value.
     */
    public static int getColumnPadding() {
        return COLUMN_PADDING;
    }

    /**
     * Gets row padding amount.
     *
     * @return Row padding value.
     */
    public static int getRowPadding() {
        return ROW_PADDING;
    }

    /**
     * Formats a string with custom spacing.
     *
     * @param formatType Format type
     * @param arg Argument value
     *
     * @return formatted string
     */
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
     * Renders player map.
     *
     * @param player Player object
     *
     * @return string array with rendered output
     */
    public static String[] renderMap(Player player) {
        return player.renderMap(COLUMN_PADDING);
    }

    /**
     * Prints with formatting.
     *
     * @param format Format string
     * @param args Arguments to pass
     */
    public static void print(String format, Object... args) {
        System.out.printf(format, args);
    }

    /**
     * Wraps print function (System).
     *
     * @param arg Arguments
     */
    public static void print(String arg) {
        System.out.println(arg);
    }

    /**
     * Wraps print function (System).
     */
    public static void print() {
        System.out.println();
    }

    /**
     * Creates a column string with correct formatting.
     *
     * @return newly created column string
     */
    private static String createColumnString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(formatString(IS_ROW, "+"));

        for (int i = 1; i <= Game.COLUMNS; i++) {
            buffer.append(formatString(IS_COLUMN, i));
        }

        buffer.append(formatString(IS_SPACING, ""));

        return buffer.toString();
    }

    /**
     * Define temporary static initializer to compile.
     */
    static {
        TOTAL_PADDING = COLUMN_PADDING * Game.COLUMNS + ROW_PADDING;
        PLAYER_SPACING  = ROW_PADDING * 2;
        COLUMN_PADDING = Game.COLUMNS > 9 ? 3 : 2;
        ROW_PADDING = 1;
        ROW_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        COLUMN_STRING = createColumnString();
    }
}