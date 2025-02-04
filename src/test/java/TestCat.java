import com.example.Cat;
import com.example.Feline;
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
public class TestCat {
    private Cat cat;

    @Mock
    Feline felineMock;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Должен быть звук 'Мяу'", sound, "Мяу");
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals("Список еды должен совадать с ожидаемым списком", actualFood, expectedFood);
    }

    @Test
    public void testGetFood_Exception() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Exception exception = assertThrows(Exception.class, () -> cat.getFood());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}