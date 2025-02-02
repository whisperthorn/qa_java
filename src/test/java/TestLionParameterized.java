import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLionParameterized {
    private final String inputGender;
    private final boolean expectedMane;

    public TestLionParameterized(String inputGender, boolean expectedMane) {
        this.inputGender = inputGender;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Unknown", false}
        };
    }

    @Test
    public void testLionConstructorWithParameters() {
        Feline felineMock = Mockito.mock(Feline.class);
        try{
            Lion lion = new Lion(inputGender, felineMock);
            assertEquals("Грива не соответствует ожидаемой", expectedMane, lion.doesHaveMane());
        } catch (Exception e) {
            assertEquals("Исключение отличается от ожидаемого","Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}