import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MyClassWithServiceDependencyTestNoMock {
    public MyClassWithServiceDependency sut;
    private MyService myService;

    private static final List<Integer> MY_TEST_LIST = Arrays.asList(5, 2, 4, -1);

    @Before
    public void init() {         //this method is called before every unit test
        //mock dependency with mockito
        myService = new MyService();
    }

    @Test
    public void checkMaxValue() {
        //init sut
        sut = new MyClassWithServiceDependency(myService);
        //call method to be tested
        sut.checkMaxValueFromIntArray(MY_TEST_LIST);
        //check that the produced result is the expected one
        assertEquals(5, sut.maxResult, 0);
    }

    @Test
    public void checkMinValue() {
        //init sut
        sut = new MyClassWithServiceDependency(myService);
        //call method to be tested
        sut.checkMinValueFromIntArray(MY_TEST_LIST);
        //check that the produced result is the expected one
        assertEquals(-1, sut.minResult, 0);
    }
}
