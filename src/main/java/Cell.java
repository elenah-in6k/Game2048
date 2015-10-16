/**
 * Created by employee on 10/16/15.
 */
public class Cell {
    int row;
    int column;
    int cellValue;
    int numberCell;


    public Cell(int numberCell, int row, int column, int cellValue) {
        this.numberCell = numberCell;
        this.row = row;
        this.column = column;
        this.cellValue = cellValue;

    }

    public int getNumberCell(){
        return numberCell;
    }

    public int getCellRow() {
        return row;
    }

    public int getCellColumn() {
        return column;
    }

    public int getCellValue() {
        return cellValue;
    }
}
