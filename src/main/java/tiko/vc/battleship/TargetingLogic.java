package tiko.vc.battleship;

import java.util.Random;
import static tiko.vc.battleship.Game.*;
import java.util.ArrayList;

/**
 * A class that handles the targeting of shots.
 */
public class TargetingLogic {
	
    /**
     * Define random number generator.
     */
    private Random rng;

	/**
	 * Contains the information of the game map positions, and priorites the positions.
	 */
	private int[] priorityMap;

    /**
     * Define array for logic data.
     */
    private final ArrayList<HitLogic> logics;

    /**
     * Define a priority for ignored cells.
     */
    private final static int IGNORE_PRIORITY = 0;

    /**
     * Override constructor.
     */
    public TargetingLogic() {
        logics = new ArrayList<>();
        rng = new Random();

        priorityMap = new int[MAP_SIZE];
        int currentRow = rng.nextInt(2) + 1;

        for (int i = 0; i < priorityMap.length; i++) {
            int p = (i + 1) % 2;
            priorityMap[i] = currentRow % 2 == 0 ? 1 + p : 2 - p;
 
            if (COLUMNS % 2 == 0 && (i + 1) % COLUMNS == 0) {
                currentRow++;
            }
        }
    }

    /**
     * Gets highest available priority from the map.
     * 
     * @return value with highest priority
     */
    private int getHighestPriorityValue() {
        int highestValue = IGNORE_PRIORITY;

        for (int priority : priorityMap) {
            if (priority > highestValue) {
                highestValue = priority;
            }
        }

        return highestValue;
    }

    /**
     * Gets list of cells with highest priority.
     *
     * @return a list of cells
     */
    private ArrayList<Integer> getPriorityList() {
        int highestPriority = getHighestPriorityValue();
        ArrayList<Integer> priorities = new ArrayList<>();
 
        for (int i = 0; i < priorityMap.length; i++) {
            if (priorityMap[i] == highestPriority) {
                priorities.add(i);
            }
        }
 
        return priorities;
    }

    /**
     * Picks random cell from priority map.
     *
     * @return cell index
     */
    private int getRandomShotIndex() {
        ArrayList<Integer> indexes = getPriorityList();
 
        return indexes.get(rng.nextInt(indexes.size()));
    }

    /**
     * Gets next available index from logic.
     *
     * @return cell index
     */
    public int nextShotIndex() {
        if (!logics.isEmpty()) {
            HitLogic logic = logics.get(0);
 
            if (!logic.hasLogic()) {
                logic.nextLogic();
                return nextShotIndex();
            }
 
            return logic.processLogic();
        }
 
        return getRandomShotIndex();
    }

    /**
     * Creates new shot logic data.
     * 
     * @param index Cell index
     * @param value Cell type
     */
    public void setShotData(int index, int value) {
        priorityMap[index] = IGNORE_PRIORITY;
 
        if (value > 0) {
            for (HitLogic logic : logics) {
                if (logic.shotValue == value) {
                    return;
                }
            }
 
            logics.add(new HitLogic(index, value));
        } else if (!logics.isEmpty()) {
            if (value < 0) {
                for (HitLogic logic : logics) {
                    if (logic.shotValue == Math.abs(value)) {
                        logic.resetLogic(INVALID_VALUE);
                        break;
                    }
                }
            } else {
                logics.get(0).nextLogic();
            }
        }
    }

    /**
     * A class containing logic when shot is hit.
     */
    private class HitLogic {

        /**
         * Define current logic to process.
         */
        private int currentLogic;

        /**
         * Define shot value and origin.
         */
        protected int shotValue, shotOrigin;

        /**
         * Define array for logic data.
         */
        private int[] logicData;

        /**
         * Override constructor.
         * 
         * @param index Cell index
         * @param value Cell type
         */
        public HitLogic(int index, int value) {
            shotValue = value;
            resetLogic(index);
        }

        /**
         * Resets logic data.
         * 
         * @param index Cell index
         */
        private void resetLogic(int index) {
            shotOrigin = index;
            logicData = new int[]{1, 1, 1, 1};
            currentLogic = rng.nextInt(logicData.length);
 
            if (index == INVALID_VALUE) {
                logics.remove(this);
            }
        }

        /**
         * Jumps to next logic if there is one.
         */
        private void nextLogic() {
            logicData[currentLogic] = INVALID_VALUE;
            int logicSum = 0;
 
            for (int value : logicData) {
                logicSum += value;
 
                if (logicSum == -logicData.length) {
                    resetLogic(INVALID_VALUE);
                    return;
                }
            }
 
            currentLogic = ++currentLogic % logicData.length;
        }

        /**
         * Checks if logic is valid.
         * 
         * @param index Cell index
         * 
         * @return true if index is valid, otherwise false
         */
        private boolean isValidLogic(int index) {
            if (index >= 0 && index < MAP_SIZE) {
                if ((index % COLUMNS == shotOrigin % COLUMNS)
                || (index / COLUMNS == shotOrigin / COLUMNS)) {
                    return index != shotOrigin
                           && priorityMap[index] > IGNORE_PRIORITY;
                }
            }
 
            return false;
        }

        /**
         * Processes current logic.
         * 
         * @return index of next valid logic.
         */
        private int processLogic() {
            int index = getLogic();
 
            switch (currentLogic) {
                case 0:
                    index = shotOrigin - (index * COLUMNS);
                    break;
                case 1:
                    index = shotOrigin + (index * COLUMNS);
                    break;
                case 2:
                    index = shotOrigin - index;
                    break;
                case 3:
                    index = shotOrigin + index;
                    break;
            }
 
            if (isValidLogic(index)) {
                return index;
            }
 
            nextLogic();
 
            return shotOrigin != INVALID_VALUE ? processLogic() : INVALID_VALUE;
        }

        /**
         * Gets current logic and move to next one.
         *
         * @return current logic data
         */
        private int getLogic() {
            return logicData[currentLogic]++;
        }

        /**
         * Checks if logic is not invalidated.
         * 
         * @return true if logic is valid, otherwise false
         */
        private boolean hasLogic() {
            return logicData[currentLogic] != INVALID_VALUE;
        }

        /**
         * 
         * @return
         */
        public int getShotOrigin() {
            return;
        }
    }
}