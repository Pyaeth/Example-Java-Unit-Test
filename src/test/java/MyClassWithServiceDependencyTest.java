import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyClassWithServiceDependencyTest {
    public MyClassWithServiceDependency sut;
    private MyService myService;

    @Before
    public void init() {         //this method is called before every unit test
    //mock dependency with mockito
        myService = mock(MyService.class);
    }

    @Test
    public void checkMaxValue() {
        //pass the mock as parameter to the sut
        sut = new MyClassWithServiceDependency(myService);
        //define desired behavior of service - e.g.: when the computeMax() method of the service is called, no matter the parameter, always return 11
        when(myService.computeMax(any())).thenReturn(11);

        //call method to be tested
        sut.checkMaxValueFromIntArray(new ArrayList<>());
        //check that the produced result is the expected one
        assertEquals(11, sut.maxResult, 0);
    }

    @Test
    public void checkMinValue() {
        //pass the mock as parameter to the sut
        sut = new MyClassWithServiceDependency(myService);
        //define desired behavior of service - e.g.: when the computeMin() method of the service is called, no matter the parameter, always return -1
        when(myService.computeMin(any())).thenReturn(-1);

        //call method to be tested
        sut.checkMinValueFromIntArray(new ArrayList<>());
        //check that the produced result is the expected one
        assertEquals(-1, sut.maxResult, 0);
    }
}
