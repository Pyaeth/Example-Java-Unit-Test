import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyClassTest {
    private MyClass sut; //sut = system under test

    @Test(expected = MyCustomException.class)
    public void shouldThrowExceptionWhenDividedByZero() throws MyCustomException {
        sut = new MyClass(2, 0);
        sut.division();
    }

    @Test
    public void shouldDivideGivenInput() throws MyCustomException {
        sut = new MyClass(1, 2);
        double result = sut.division();
        assertEquals(0.5, result, 1e-15);
    }

    @Test
    public void shouldSumGivenInput() {
        sut = new MyClass(2, 3);
        int result = sut.addition();
        assertEquals(5, result, 0.0);
    }

    @Test
    public void shouldSubtractGivenInput() {
        sut = new MyClass(5, 4);
        int result = sut.subtraction();
        assertEquals(1, result, 0.0);
    }

    @Test
    public void shouldMultiplyGivenInput() {
        sut = new MyClass(2, 5);
        int result = sut.product();
        assertEquals(10, result, 0.0);
    }
}