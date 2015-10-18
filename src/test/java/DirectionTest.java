import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Алена on 18.10.2015.
 */
public class DirectionTest {
    Direction direction;

    @Test
    public void getDirection(){
        direction = Direction.left;
        assertThat(direction = Direction.up, is(Direction.up));

    }

}
