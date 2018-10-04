package tiko.vc.battleship;

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
     * Resets total shots fired.
     */
    public final void resetShotsFired() {
        shotAccuracy = 0;
        shotStreak = 0;

        shotsMissed = 0;
        shotsHit = 0;
    }

    /**
     * Resets wins and losses.
     */
    public final void resetWinLossRatio() {
        winLossRatio = 0;

        gamesLost = 0;
        gamesWon = 0;
    }
}
