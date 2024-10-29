package cleancode.minesweeper.tobe;

public class Cell {

    private int nearbyLandMineCount;
    private boolean isLandMind;
    private boolean isFlagged;
    private boolean isOpened;

    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";


    private Cell(int nearbyLandMineCount, boolean isLandMind, boolean isFlagged, boolean isOpened) {
        this.nearbyLandMineCount = nearbyLandMineCount;
        this.isLandMind = isLandMind;
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    public static Cell of(int nearbyLandMineCount, boolean isLandMind, boolean isFlagged, boolean isOpened) {
        return new Cell(nearbyLandMineCount, isLandMind, isFlagged, isOpened);
    }

    public static Cell create() {
        return of(0, false, false, false);
    }

    public void flag() {
        this.isFlagged = true;
    }

    public boolean isLandMine() {
        return this.isLandMind;
    }

    public void turnOnLandMind() {
        this.isLandMind = true;
    }

    public void updateNearbyLandMineCount(int count) {
        this.nearbyLandMineCount = count;
    }

    public boolean hasLandMineCount() {
        return this.nearbyLandMineCount != 0;
    }

    public boolean isChecked() {
        return isFlagged || isOpened;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public String getSign() {
        if (isOpened) {
            if (isLandMind) {
                return LAND_MINE_SIGN;
            }
            if (hasLandMineCount()) {
                return String.valueOf(nearbyLandMineCount);
            }
            return EMPTY_SIGN;
        }

        if (isFlagged) {
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }

}
