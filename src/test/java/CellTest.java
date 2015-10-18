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
        cell = new Cell(0, 0);
        assertThat(cell.getCellValue(), is(0));

        cell = new Cell(1, 1);
        assertThat(cell.getCellValue(), is(1));
    }

    @Test
    public void testIsEmptyCell(){
        cell = new Cell (0,1);
        assertThat(cell.IsEmptyCell(), is(false));
    }
}
