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

    /**
     * Increases shots.
     *
     * @param hit Hit or miss
     */
    public void increaseShotsFired(boolean hit) {
        if (hit) {
            shotsHit++;
            currentStreak++;
        } else {
            shotsMissed++;
            currentStreak = 0;
        }

        if (shotsHit > 0) {
            shotAccuracy = (double) shotsHit / (shotsMissed + shotsHit);
        }

        if (currentStreak > shotStreak) {
            shotStreak = currentStreak;
        }
    }

    /**
     * Increases games played.
     *
     * @param win Win or loss
     */
    public void increaseGamesPlayed(boolean win) {
        if (win) {
            gamesWon++;
        } else {
            gamesLost++;
        }

        if (gamesWon > 0) {
            winLossRatio = (double) gamesWon / (gamesLost + gamesWon);
        }
    }

    /**
     *
     */
    public double getShotAccuracy() {
        return shotAccuracy * 100;
    }
}
