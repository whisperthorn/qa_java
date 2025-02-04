import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class TestFeline {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Ожидается Кошачьи", "Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals("Ожидается количество: 1",1, feline.getKittens());
    }

    @Test
    public void testGetFood_Exception() {
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестное Животное"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}