import java.util.List;
import java.util.NoSuchElementException;

public class MyClassWithServiceDependency {
    public final MyService myService;
    public int maxResult;
    public int minResult;

    public MyClassWithServiceDependency(MyService myService) {
        this.myService = myService;
    }

    public int checkMaxValueFromIntArray(List<Integer> myArray) throws NoSuchElementException {
        System.out.println("Max value is: " + myService.computeMax(myArray));
        this.maxResult = myService.computeMax(myArray);
        return maxResult;
    }

    public int checkMinValueFromIntArray(List<Integer> myArray) throws NoSuchElementException {
        System.out.println("Min value is: " + myService.computeMin(myArray));
        this.minResult = myService.computeMin(myArray);
        return minResult;
    }
}
