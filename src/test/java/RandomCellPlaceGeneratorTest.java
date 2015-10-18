import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellPlaceGeneratorTest {
    GameField gameField = new GameField();
    public CellPlaceGenerator cellPlace = new RandomCellPlaceGenerator(gameField.gameField);

    @Test
    public void testGetCellPlace(){

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            values.add(cellPlace.getCellNumber());
        }
        assertThat(values, hasItems(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
    }
}
