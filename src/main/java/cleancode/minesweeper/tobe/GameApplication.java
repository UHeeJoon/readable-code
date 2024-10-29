package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Advanced;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.gamelevel.VeryBeginner;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel level = new VeryBeginner();
        Minesweeper minesweeper = new Minesweeper(level);
        minesweeper.run();
    }

}
