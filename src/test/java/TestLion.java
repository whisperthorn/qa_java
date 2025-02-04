import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;
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
    public void testGetKittens() {
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
    public void testGetFood_Exception() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Exception exception = assertThrows(Exception.class, () -> lion.getFood());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void testConstructor_Exception()  {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Unknown", felineMock));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
