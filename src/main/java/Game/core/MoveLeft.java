package Game.core;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveLeft extends Move {

    public MoveLeft(List<Cell> gameField) {
        super(gameField);
    }
    @Override
    void offset(int initialValue, int finalValue) {
        int j = 0;
        while (finalValue >= j) {
            int i = initialValue;
            while ((finalValue > i)) {
                Pair pair = getCellPair(i);
                pair.pull();
                i++;
            }
            j++;
            ;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
        int i = initialValue;
        while ((finalValue > i)) {
            Pair pair = getCellPair(i);
            gameScore += pair.merge();
            i++;
        }
    }
    private Pair getCellPair(int posInLine) {
        return new Pair(gameField.get(posInLine), gameField.get(posInLine + 1));
    }
    @Override
    int getInitialValue(int i) {
        return i * SIZE;
    }

    @Override
    int getFinalValue(int i) {
        return ((i + 1) * SIZE) - 1;
    }

}
