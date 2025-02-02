import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFelineParameterized {
    private final int inputKittensCount;
    private final int expectedKittensCount;

    public TestFelineParameterized(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {5, 5},
                {10, 10},
                {0, 0}
        };
    }

    @Test
    public void testGetKittensWithParameters() {
        Feline feline = new Feline();
        assertEquals("Количество котят не совпадает с ожидаемым", expectedKittensCount, feline.getKittens(inputKittensCount));
    }

}