/**
 * Created by employee on 10/16/15.
 */
public class Cell {
    int cellValue;
    int numberCell;


    public Cell(int numberCell, int cellValue) {
        this.numberCell = numberCell;
        this.cellValue = cellValue;

    }

    public int getNumberCell(){

        return numberCell;
    }

    public int getCellValue() {

        return cellValue;
    }

    public boolean IsEmptyCell() {
        if (cellValue == 0){
            return true;
        }
        return false;
    }
    static Cell createEmptyCell(int number){
        return new Cell (number,0);
    }
    boolean isEqualsCellValue(Cell cell){
        if (cellValue == cell.cellValue){
            return true;
        }
        return false;
    }
}
