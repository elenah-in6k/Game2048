import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class StaticCellPlaceGeneratorTest {
    public CellPlaceGenerator staticCellPlace;

    @Test
    public void testGetCellPlace(){
        staticCellPlace = new StaticCellPlaceGenerator(1,2);
        assertThat(staticCellPlace.getCellRow(), is(1));
        assertThat(staticCellPlace.getCellColumn(), is(2));
        assertThat(staticCellPlace.getCellRow(), is(1));
        assertThat(staticCellPlace.getCellColumn(), is(2));

        staticCellPlace = new StaticCellPlaceGenerator(3,0);
        assertThat(staticCellPlace.getCellRow(), is(3));
        assertThat(staticCellPlace.getCellColumn(), is(0));
        assertThat(staticCellPlace.getCellRow(), is(3));
        assertThat(staticCellPlace.getCellColumn(), is(0));


    }
}
