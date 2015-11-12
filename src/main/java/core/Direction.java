package core;

/**
 * Created by ����� on 18.10.2015.
 */
public enum Direction {
    RIGHT,
    LEFT,
    UP,
    DOWN;
    abstract class GameIterator{
       abstract int getInitialValue(int index);
        abstract int getFinalValue(int index);
        abstract int getGameIterator(int index);
    }

}
