import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellFillerTest {
    CellFiller valueOfCell = new RandomCellFiller();

    @Test
    public void testRandomValueOfCell() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            values.add(valueOfCell.getCellValue());
        }
        assertThat(values, hasItems(2, 4));
    }

}
