import java.util.Arrays;
import java.util.List;

public class MyClass {

    int x;
    int y;

    public MyClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int addition() {
        return this.x + this.y;
    }

    public int product() {
        return this.x * this.y;
    }

    public int subtraction() {
        return this.x - this.y;
    }

    public double division() throws MyCustomException {
        if (this.y == 0) {
            throw new MyCustomException();
        }
        return (double) this.x / this.y;
    }

    public static void main(String []args) {
        //Example 1: simple class with no service (NO dependency injection)
        MyClass example = new MyClass(5, 2);
        System.out.println("Sum is: " + example.addition());
        System.out.println("Product is: " + example.product());
        System.out.println("Subtraction is: " + example.subtraction());
        try {
            System.out.println("Division is: " + example.division());
        } catch (MyCustomException e) {
            //we treated the exception here
        }

        //Example 2: class with 1 service as a dependency (dependency injection)
        MyClassWithServiceDependency exampleWithDependency = new MyClassWithServiceDependency(new MyService());
        List<Integer> myList = Arrays.asList(-1, 5, 0, 2, -7, 15, 10001, -22, -14, 10);
        exampleWithDependency.checkMaxValueFromIntArray(myList);
    }
}