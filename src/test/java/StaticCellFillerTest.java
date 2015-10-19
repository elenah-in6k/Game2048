import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class StaticCellFillerTest {
    CellFiller valueOfCell;

    @Test
    public void testStaticValueOfCell(){
        valueOfCell = new StaticCellFiller(0);
        assertThat(valueOfCell.getCellValue(), is(0));
        assertThat(valueOfCell.getCellValue(), is(0));

        valueOfCell = new StaticCellFiller(2);
        assertThat(valueOfCell.getCellValue(), is(2));
        assertThat(valueOfCell.getCellValue(), is(2));
    }


}
