import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellValueGenerator implements CellValueGenerator {
    private Random random = new Random();

    @Override
    public int getCellValue() {
        return random.nextInt(11) == 0 ? 4 : 2;
    }

}
