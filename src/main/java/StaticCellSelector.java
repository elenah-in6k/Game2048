import java.util.List;

/**
 * Created by employee on 10/16/15.
 */
public class StaticCellSelector implements CellSelector {

    @Override
    public Cell selectCell(List<Cell> cells) {
        return cells.get(0);
    }
}
