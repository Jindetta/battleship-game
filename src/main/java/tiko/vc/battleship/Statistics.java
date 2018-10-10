package tiko.vc.battleship;

/**
 * A class containing statistics information.
 *
 * @version 2018.0926
 * @since 1.8
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
        resetShotsFired();
        resetWinLossRatio();
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

        setGamesLost(0);
        setGamesWon(0);
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
            setGamesWon(getGamesWon() + 1);
        } else {
            setGamesLost(getGamesLost() + 1);
        }

        if (getGamesWon() > 0) {
            winLossRatio = (double) getGamesWon() / (getGamesLost() + getGamesWon());
        }
    }

    /**
     * Sets games won number.
     *
     * @param gamesWon number of games won
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * Gets games won number.
     *
     * @return gamesWon number of games won
     */
    public int getGamesWon() {
        return this.gamesWon;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    /**
     * Gets games lost number.
     *
     * @return gamesLost number of games lost
     */
    public int getGamesLost() {
        return this.gamesLost;
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

    /**
     * Gets current streak.
     *
     * @return Current streak value.
     */
    public int getCurrentStreak() {
        return currentStreak;
    }

    /**
     * Gets shots hit amount.
     *
     * @return Shots hit value.
     */
    public int getShotsHit() {
        return shotsHit;
    }

    /**
     * Gets amount of missed shots.
     *
     * @return Shots missed value.
     */
    public int getShotsMissed() {
        return shotsMissed;
    }

    /**
     * Gets shot streak.
     *
     * @return Shot streak value.
     */
    public int getShotStreak() {
        return shotStreak;
    }

    @Override
    public String toString() {
        String results = "Games played: " + (getGamesWon() + getGamesLost()) + "\n";

        results += "Win/Loss ratio: " + getWinLossRatio()
                + "% (W" + getGamesWon() + "/L" + getGamesLost() + ")\n";
        results += "Shots fired: " + (shotsHit + shotsMissed) + "\n";
        results += "Shot accuracy: " + getShotAccuracy()
                + "% (H" + shotsHit + "/M" + shotsMissed + ")\n";
        results += "Longest streak of continued hits: " + shotStreak;

        return results;
    }
}