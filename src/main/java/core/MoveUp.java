package core;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveUp extends Move {
    public MoveUp(List<Cell> gameField) {
        super(gameField);
    }

    @Override
    void offset(int initialValue, int finalValue) {
        int j = initialValue;
       // while (finalValue >= j)
        for(;j!=finalValue;j += SIZE){
            int i = initialValue;
            while ((finalValue >= i)) {
                Pair pair = getCellPair(i);
                pair.pull();
                i += SIZE;
            }

        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
        int i = initialValue;
        while ((finalValue >= i)) {
            Pair pair = getCellPair(i);
            gameScore += pair.merge();
            i += SIZE;
        }
    }

    private Pair getCellPair(int posInLine) {
        return new Pair(gameField.get(posInLine), gameField.get(posInLine + SIZE));
    }

    @Override
    int getInitialValue(int i) {
        return i;
    }

    @Override
    int getFinalValue(int i) {
        return (SIZE * 2) + i;
    }

}
