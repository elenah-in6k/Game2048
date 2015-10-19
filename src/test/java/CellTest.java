import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class CellTest {
    Cell cell;

    @Test
    public void testCreateEmptyCell() {
        cell = new Cell(0);
        assertThat(cell.getCellValue(), is(0));
        cell = new Cell(1);
        assertThat(cell.getCellValue(), is(1));
    }

    @Test
    public void testIsEmptyCell() {
        cell = new Cell(1);
        assertThat(cell.isEmpty(), is(false));
    }

    @Test
    public void testIsCellWith2048() {
        cell = new Cell(2);
        assertThat(cell.isCellWith2048(), is(false));
        cell = new Cell(2048);
        assertThat(cell.isCellWith2048(), is(true));
    }
}
