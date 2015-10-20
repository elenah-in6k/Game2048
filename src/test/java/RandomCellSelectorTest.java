import Filler.CellSelector;
import Filler.RandomCellSelector;
import Game.Cell;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellSelectorTest {
    public CellSelector cellPlace = new RandomCellSelector();

    @Test
    public void testReturnsCellFromSingleCellList() {
        Cell cell = new Cell(1);
        List<Cell> cells = Collections.singletonList(cell);
        assertThat(cellPlace.selectCell(cells), sameInstance(cell));
    }
}
