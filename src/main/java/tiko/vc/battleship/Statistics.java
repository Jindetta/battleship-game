package tiko.vc.battleship;

/**
 * A class containing statistics information.
 *
 * @version 1.0
 * @since 2018.0926
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
     * Gets shot accuracy.
     *
     * @return shot accuracy percentage
     */
    public double getShotAccuracy() {
        return shotAccuracy * 100;
    }

    /**
     * Gets win/loss ratio.
     *
     * @return win/loss percentage
     */
    public double getWinLossRatio() {
        return winLossRatio * 100;
    }

    @Override
    public String toString() {
        String results = "Games played: " + (gamesWon + gamesLost) + "\n";

        results += "Win/Loss ratio: " + getWinLossRatio()
                + "% (W" + gamesWon + "/L" + gamesLost + ")\n";
        results += "Shots fired: " + (shotsHit + shotsMissed) + "\n";
        results += "Shot accuracy: " + getShotAccuracy()
                + "% (H" + shotsHit + "/M" + shotsMissed + ")\n";
        results += "Longest streak of continued hits: " + shotStreak;

        return results;
    }
}
