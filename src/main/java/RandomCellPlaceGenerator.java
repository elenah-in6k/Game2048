import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellPlaceGenerator implements CellPlaceGenerator {
    Random random = new Random();
    private List<Cell> gameField;
    private ArrayList<Integer> emptyCells = new ArrayList<>();

    public RandomCellPlaceGenerator(List<Cell> gameField) {
        this.gameField = gameField;
        searchEmptyCell();
    }

    @Override
    public int getCellNumber() {

        int emptyCellNumber = random.nextInt(emptyCells.size());
        int cellNumber = emptyCells.get(emptyCellNumber);
        emptyCells.remove(emptyCellNumber);
        emptyCells.trimToSize();
        return cellNumber;
    }

    @Override
    public void searchEmptyCell() {
            for (Cell cell : gameField) {
                if (cell.isEmptyCell()) {
                    emptyCells.add(cell.numberCell);
                }
            }
    }
}
