import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class CellTest {
    Cell cell;

    @Test
    public void testCreateEmptyCell(){
        cell = new Cell(0, 0, 0);
        assertThat(cell.getCellRow(), is(0));
        assertThat(cell.getCellColumn(), is(0));
        assertThat(cell.getCellValue(), is(0));

        cell = new Cell(2, 3, 1);
        assertThat(cell.getCellRow(), is(2));
        assertThat(cell.getCellColumn(), is(3));
        assertThat(cell.getCellValue(), is(1));
    }
}
