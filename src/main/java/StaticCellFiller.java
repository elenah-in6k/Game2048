/**
 * Created by employee on 10/16/15.
 */
public class StaticCellFiller implements CellFiller {
    int valueOfCell;
    public StaticCellFiller(int value) {
            valueOfCell = value;
    }

    public int getCellValue() {
        return valueOfCell;
    }


}
