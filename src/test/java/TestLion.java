import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    private Lion lion;

    @Mock
    Feline felineMock;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testGetKittens(){
        int expectedKittens = 1;
        when(felineMock.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        assertEquals("Ожидается количество: 1", expectedKittens, actualKittens);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals("Список еды должен совадать с ожидаемым списком", actualFood, expectedFood);
    }

    @Test
    public void testGetFood_Exception() {
        try {
            Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            lion.getFood();
            fail("Ожидается исключение");
        } catch (Exception e) {
            assertEquals("Исключение отличается от ожидаемого","Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}