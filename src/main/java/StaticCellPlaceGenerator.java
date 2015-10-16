/**
 * Created by employee on 10/16/15.
 */
public class StaticCellPlaceGenerator implements CellPlaceGenerator {
    int column;
    int row;

    public StaticCellPlaceGenerator(int row, int column) {
        this.column = column;
        this.row = row;
    }

    @Override
    public int getCellRow() {
        return row;
    }

    @Override
    public int getCellColumn() {
        return column;
    }
}
