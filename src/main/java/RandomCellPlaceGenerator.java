import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellPlaceGenerator implements CellPlaceGenerator {
    Random random = new Random();

    @Override
    public Cell selectCell(List<Cell> cells) {
        return cells.get(random.nextInt(cells.size()));
    }

}
