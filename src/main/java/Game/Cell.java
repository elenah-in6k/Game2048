package Game;

/**
 * Created by employee on 10/16/15.
 */
public class Cell {
    public int cellValue;
    int numberCell;

    public Cell(int cellValue) {
//        this.numberCell = numberCell;
        this.cellValue = cellValue;

    }

    public int getCellValue() {

        return cellValue;
    }

    public boolean isEmpty() {
        if (cellValue == 0) {
            return true;
        }
        return false;
    }

    static Cell createEmptyCell() {
        return new Cell(0);
    }

    boolean isEquals(Cell cell) {
        if (cellValue == cell.cellValue) {
            return true;
        }
        return false;
    }

    public boolean isCellWith2048() {
        if (cellValue == 2048) {
            return true;
        }
        return false;
    }
}
