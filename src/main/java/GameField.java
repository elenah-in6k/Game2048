import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    List<Cell> gameField = new ArrayList<>();
    String gameFieldValue ;
    private CellValueGenerator cellValue = new StaticCellValueGenerator(2);
    private CellPlaceGenerator cellPlace = new RandomCellPlaceGenerator();
    final int size = 4;
    int cellRow;
    int cellColumn;


    public GameField() {
        int n = 0;
        for( int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                gameField.add(new Cell(n, i, j, 0));
                n++;
            }
        }
    }

    public void fillEmptyCell() {
        cellRow = cellPlace.getCellRow();
        cellColumn = cellPlace.getCellColumn();
         for(int i = 0; (i < 20)&&(!IsEmptyCell(cellRow,cellColumn)); i++){
             cellRow = cellPlace.getCellRow();
             cellColumn = cellPlace.getCellColumn();
        }
        gameField[cellRow][cellColumn] = cellValue.getCellValue();


    }
    public String toString(){
        gameFieldValue = "";
        for(Cell cell :gameField){
                gameFieldValue += cell.cellValue + " ";

        }
        return gameFieldValue;
    }

    public boolean IsEmptyCell(int i) {
        if (gameField.get(i).cellValue == 0){
            return true;
        }
        return false;
    }

}
