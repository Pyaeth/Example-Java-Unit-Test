public class MyCustomException extends Exception {
    public MyCustomException() {
        super("Exception thrown: cannot divide by 0!");
    }
}
