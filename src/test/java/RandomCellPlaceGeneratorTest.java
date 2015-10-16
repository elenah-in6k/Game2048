import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellPlaceGeneratorTest {
    public CellPlaceGenerator staticCellPlace;
    @Test
    public void testGetCellPlace(){
        staticCellPlace = new RandomCellPlaceGenerator();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            values.add(staticCellPlace.getCellRow());
            values.add(staticCellPlace.getCellColumn());
        }
        assertThat(values, hasItems(0,1,2,3,0,1,2,3));


    }
}
