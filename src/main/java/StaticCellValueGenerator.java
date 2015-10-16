/**
 * Created by employee on 10/16/15.
 */
public class StaticCellValueGenerator implements CellValueGenerator {
    int valueOfCell;
    public StaticCellValueGenerator(int value) {
            valueOfCell = value;
    }

    public int getCellValue() {
        return valueOfCell;
    }


}
