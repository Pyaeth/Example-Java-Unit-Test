import model.Person;
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
    public void checkMaxValue() throws Exception {
        final int DESIRED_MAX_VALUE = 11;

        //pass the mock as parameter to the sut
        sut = new MyClassWithServiceDependency(myService);
        //define desired behavior of service - e.g.: when the computeMax() method of the service is called, no matter the parameter, always return 11
        // => the hasAccess method is never called during testing
        when(myService.computeMax(any())).thenReturn(DESIRED_MAX_VALUE);

        //call method to be tested
        //in this case, we check that checkMaxValueFromIntArray method properly set the sut.maxResult with the fixed value 11
        //we are not interested in how the max value is calculated in the service, we only want to check that
        //given the service call returns 11
        //then the tested class' attribute maxResult is set to 11
        sut.checkMaxValueFromIntArray(new ArrayList<>());
        //check that the produced result is the expected one
        assertEquals(11, sut.maxResult, 0);
    }

    @Test (expected = Exception.class)
    public void checkMinValueFailsDueToAccess() throws Exception {
        //pass the mock as parameter to the sut
        sut = new MyClassWithServiceDependency(myService);

        //define desired behavior of service: when the computeMin() method of the service is called,
        //we know it calls the hasAccess method first, so in order to throw an exception
        //we define the behavior of checkAccess -> it must return false
        when(myService.checkAccess(any())).thenReturn(false);

        //only for didactic purposes, we force the computeMin method to be called
        //whenever using mocks, the real methods are not called
        when(myService.computeMin(any())).thenCallRealMethod();
        //call method to be tested
        sut.checkMinValueFromIntArray(new ArrayList<>());
    }
}
