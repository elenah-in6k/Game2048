package Game;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public abstract class Move {
    int gameScore;
    List<Cell> gameField;
    final int SIZE = GameField.SIZE;
    abstract void offset(int initialValue, int finalValue);
    abstract void getSumEqualCellsAfterOffset(int initialValue, int finalValue);
    abstract int getInitialValue(int i);
    abstract int getFinalValue(int i);
    Move(List<Cell> gameField){
        this.gameField = gameField;
    }
    public int move(int i){
        int initialValue = getInitialValue(i);
        int finalValue = getFinalValue(i);
        offset(initialValue, finalValue);
        getSumEqualCellsAfterOffset(initialValue, finalValue);
        offset(initialValue, finalValue);
        return gameScore;
    }

}
