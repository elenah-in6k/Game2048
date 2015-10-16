import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by employee on 10/16/15.
 */
public class StaticCellValueGeneratorTest {
    CellValueGenerator valueOfCell;

    @Test
    public void testStaticValueOfCell(){
        valueOfCell = new StaticCellValueGenerator(0);
        assertThat(valueOfCell.getCellValue(), is(0));
        assertThat(valueOfCell.getCellValue(), is(0));

        valueOfCell = new StaticCellValueGenerator(2);
        assertThat(valueOfCell.getCellValue(), is(2));
        assertThat(valueOfCell.getCellValue(), is(2));
    }


}
