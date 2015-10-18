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
        staticCellPlace = new StaticCellPlaceGenerator(1);
        assertThat(staticCellPlace.getCellNumber(), is(1));
        assertThat(staticCellPlace.getCellNumber(), is(1));


        staticCellPlace = new StaticCellPlaceGenerator(3);
        assertThat(staticCellPlace.getCellNumber(), is(3));
        assertThat(staticCellPlace.getCellNumber(), is(3));


    }
}
