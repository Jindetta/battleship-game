package battleship;

/**
 * A class containing statistics information.
 */
public class Statistics {

    /**
     * Records shots missed.
     */
    private int shotsMissed;

    /**
     * Records shots hit.
     */
    private int shotsHit;

    /**
     * Records biggest shot streak.
     */
    private int shotStreak;

    /**
     * Records current shot streak.
     */
    private int currentStreak;

    /**
     * Records games lost.
     */
    private int gamesLost;

    /**
     * Records games won.
     */
    private int gamesWon;

    /**
     * Records win/loss ratio.
     */
    private double winLossRatio;

    /**
     * Records shot accuracy.
     */
    private double shotAccuracy;

    /**
     * Override constructor.
     */
    public Statistics() {

    }

    /**
     *
     */
    public final void resetShotsFired() {

    }
}
