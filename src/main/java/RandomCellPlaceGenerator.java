import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellPlaceGenerator implements CellPlaceGenerator {
    Random random = new Random();
    @Override
    public int getCellRow() {
        return random.nextInt(4);
    }

    @Override
    public int getCellColumn() {
        return random.nextInt(4);
    }


}
