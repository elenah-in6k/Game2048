import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellValueGeneratorTest {
    CellValueGenerator valueOfCell = new RandomCellValueGenerator();

    @Test
    public void testRandomValueOfCell() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            values.add(valueOfCell.getCellValue());
        }
        assertThat(values, hasItems(2, 4));
    }

}
