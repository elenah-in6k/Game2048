/**
 * Created by employee on 10/16/15.
 */
public class StaticCellPlaceGenerator implements CellPlaceGenerator {

    int cellNumber;

    public StaticCellPlaceGenerator(int number) {

        this.cellNumber = cellNumber;
    }

    @Override
    public int getCellNumber() {
        return cellNumber;
    }

    @Override
    public void searchEmptyCell() {

    }
}
